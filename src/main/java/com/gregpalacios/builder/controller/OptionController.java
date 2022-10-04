package com.gregpalacios.builder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.builder.dto.ControlOptionDTO;
import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.exception.ModeloNotFoundException;
import com.gregpalacios.builder.model.ControlOption;
import com.gregpalacios.builder.service.IControlOptionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/opciones")
@Tag(name = "Option Controller", description = "Operaciones para el manejo de las opciones")
public class OptionController {

	@Autowired
	private IControlOptionService service;

	@Operation(summary = "Listar todas las opciones")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<ControlOption>> listar() throws HandlerException {
		List<ControlOption> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar las opciones por ID del control")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/control/{id}")
	public ResponseEntity<List<ControlOption>> listarPorIdControl(@PathVariable("id") Integer id)
			throws HandlerException {
		List<ControlOption> lista = service.listarPorIdControl(id);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar las opciones por KEY del control")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/control/k/{key}")
	public ResponseEntity<List<ControlOption>> listarPorKeyControl(@PathVariable("key") String key)
			throws HandlerException {
		List<ControlOption> lista = service.listarPorKeyControl(key);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Obtener opción por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/{id}")
	public ResponseEntity<ControlOption> listarPorId(@PathVariable("id") Integer id) throws HandlerException {
		ControlOption obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Obtener opción por KEY")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/k/{key}")
	public ResponseEntity<ControlOption> listarPorKey(@PathVariable("key") String key) throws HandlerException {
		ControlOption obj = service.listarPorKey(key);

		if (obj == null) {
			throw new ModeloNotFoundException("KEY NO ENCONTRADO " + key);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Registrar opción")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<ControlOption> registrar(@Valid @RequestBody ControlOptionDTO dto) throws HandlerException {
		ControlOption data = new ControlOption(dto);
		ControlOption obj = service.registrar(data);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar opción")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Actualizado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PutMapping
	public ResponseEntity<ControlOption> modificar(@Valid @RequestBody ControlOptionDTO dto) throws HandlerException {
		ControlOption data = new ControlOption(dto);
		ControlOption obj = service.modificar(data);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Eliminar opción por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Eliminado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) throws HandlerException {
		ControlOption obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		obj.setEstadoReg(0);
		service.modificar(obj);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
