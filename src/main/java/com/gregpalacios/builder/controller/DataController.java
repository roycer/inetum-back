package com.gregpalacios.builder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.builder.model.ControlData;
import com.gregpalacios.builder.service.IControlDataService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/data")
@Tag(name = "Data Controller", description = "Operaciones para el manejo de la data de los formularios")
public class DataController {

	@Autowired
	private IControlDataService service;

	@Operation(summary = "Listar todos los datos registrados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<ControlData>> listar() throws Exception {
		List<ControlData> lista = service.listar();
		return new ResponseEntity<List<ControlData>>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los datos registrados por ID del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/{id}")
	public ResponseEntity<List<ControlData>> listarPorIdModulo(@PathVariable("id") Integer id) throws Exception {
		List<ControlData> lista = service.listarPorIdModulo(id);
		return new ResponseEntity<List<ControlData>>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los datos registrados por KEY del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/k/{key}")
	public ResponseEntity<List<ControlData>> listarPorKeyModulo(@PathVariable("key") String key) throws Exception {
		List<ControlData> lista = service.listarPorKeyModulo(key);
		return new ResponseEntity<List<ControlData>>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Registrar datos del formulario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<Boolean> registrarTransaccional(@Valid @RequestBody List<ControlData> data) throws Exception {
		Boolean estado;
		try {
			service.registrarTransaccional(data);
			estado = true;
		} catch (Exception e) {
			estado = false;
		}

		return new ResponseEntity<Boolean>(estado, HttpStatus.CREATED);
	}

}
