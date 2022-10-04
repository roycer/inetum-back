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

import com.gregpalacios.builder.dto.ModuloDTO;
import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.exception.ModeloNotFoundException;
import com.gregpalacios.builder.model.Modulo;
import com.gregpalacios.builder.service.IModuloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/modulos")
@Tag(name = "Modulo Controller", description = "Operaciones para el manejo de los modulos")
public class ModuloController {

	@Autowired
	private IModuloService service;

	@Operation(summary = "Listar todos los modulos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<Modulo>> listar() throws HandlerException {
		List<Modulo> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Obtener modulo por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/{id}")
	public ResponseEntity<Modulo> listarPorId(@PathVariable("id") Integer id) throws HandlerException {
		Modulo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Obtener modulo por KEY")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/k/{key}")
	public ResponseEntity<Modulo> listarPorKey(@PathVariable("key") String key) throws HandlerException {
		Modulo obj = service.listarPorKey(key);

		if (obj == null) {
			throw new ModeloNotFoundException("KEY NO ENCONTRADO " + key);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Registrar modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<Modulo> registrar(@Valid @RequestBody ModuloDTO dto) throws HandlerException {
		Modulo data = new Modulo(dto);
		Modulo obj = service.registrar(data);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Actualizado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PutMapping
	public ResponseEntity<Modulo> modificar(@Valid @RequestBody ModuloDTO dto) throws HandlerException {
		Modulo data = new Modulo(dto);
		Modulo obj = service.modificar(data);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Eliminar modulo por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Eliminado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) throws HandlerException {
		Modulo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		obj.setEstadoReg(0);
		service.modificar(obj);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
