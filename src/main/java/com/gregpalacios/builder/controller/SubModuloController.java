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

import com.gregpalacios.builder.dto.SubModuloDTO;
import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.exception.ModeloNotFoundException;
import com.gregpalacios.builder.model.SubModulo;
import com.gregpalacios.builder.service.ISubModuloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/submodulos")
@Tag(name = "SubModulo Controller", description = "Operaciones para el manejo de los submodulos")
public class SubModuloController {

	@Autowired
	private ISubModuloService service;

	@Operation(summary = "Listar todos los submodulos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<SubModulo>> listar() throws HandlerException {
		List<SubModulo> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los submodulos por ID del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/{id}")
	public ResponseEntity<List<SubModulo>> listarPorIdModulo(@PathVariable("id") Integer id) throws HandlerException {
		List<SubModulo> lista = service.listarPorIdModulo(id);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los submodulos por KEY del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/k/{key}")
	public ResponseEntity<List<SubModulo>> listarPorKeyModulo(@PathVariable("key") String key) throws HandlerException {
		List<SubModulo> lista = service.listarPorKeyModulo(key);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Obtener submodulo por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/{id}")
	public ResponseEntity<SubModulo> listarPorId(@PathVariable("id") Integer id) throws HandlerException {
		SubModulo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Obtener submodulo por KEY")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/k/{key}")
	public ResponseEntity<SubModulo> listarPorKey(@PathVariable("key") String key) throws HandlerException {
		SubModulo obj = service.listarPorKey(key);

		if (obj == null) {
			throw new ModeloNotFoundException("KEY NO ENCONTRADO " + key);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Registrar submodulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<SubModulo> registrar(@Valid @RequestBody SubModuloDTO dto) throws HandlerException {
		SubModulo data = new SubModulo(dto);
		SubModulo obj = service.registrar(data);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar submodulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Actualizado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PutMapping
	public ResponseEntity<SubModulo> modificar(@Valid @RequestBody SubModuloDTO dto) throws HandlerException {
		SubModulo data = new SubModulo(dto);
		SubModulo obj = service.modificar(data);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Eliminar submodulo por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Eliminado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) throws HandlerException {
		SubModulo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		obj.setEstadoReg(0);
		service.modificar(obj);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
