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

import com.gregpalacios.builder.dto.ControlDTO;
import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.exception.ModeloNotFoundException;
import com.gregpalacios.builder.model.Control;
import com.gregpalacios.builder.service.IControlService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/controles")
@Tag(name = "Control Controller", description = "Operaciones para el manejo de los controles")
public class ControlController {

	@Autowired
	private IControlService service;

	@Operation(summary = "Listar todos los controles")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<Control>> listar() throws HandlerException {
		List<Control> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los controles por ID del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/{id}")
	public ResponseEntity<List<Control>> listarPorIdModulo(@PathVariable("id") Integer id) throws HandlerException {
		List<Control> lista = service.listarPorIdModulo(id);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar los controles por KEY del modulo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/modulo/k/{key}")
	public ResponseEntity<List<Control>> listarPorKeyModulo(@PathVariable("key") String key) throws HandlerException {
		List<Control> lista = service.listarPorKeyModulo(key);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Obtener control por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/{id}")
	public ResponseEntity<Control> listarPorId(@PathVariable("id") Integer id) throws HandlerException {
		Control obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Obtener control por KEY")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Objeto recuperado exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/k/{key}")
	public ResponseEntity<Control> listarPorKey(@PathVariable("key") String key) throws HandlerException {
		Control obj = service.listarPorKey(key);

		if (obj == null) {
			throw new ModeloNotFoundException("KEY NO ENCONTRADO " + key);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Registrar control")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<Control> registrar(@Valid @RequestBody ControlDTO dto) throws HandlerException {
		Control data = new Control(dto);
		List<Control> lista = service.listarPorIdModulo(data.getModulo().getIdModulo());
		Integer orden = lista.size() + 1;

		data.setOrder(orden);
		Control obj = service.registrar(data);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar control")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Actualizado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PutMapping
	public ResponseEntity<Control> modificar(@Valid @RequestBody ControlDTO dto) throws HandlerException {
		Control data = new Control(dto);
		Control obj = service.modificar(data);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Operation(summary = "Eliminar control por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Eliminado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) throws HandlerException {
		Control obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		obj.setEstadoReg(0);
		service.modificar(obj);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@Operation(summary = "Actualizar los controles")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Actualizado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PutMapping("/actualizar/listado")
	public ResponseEntity<Boolean> actualizarTransaccional(@Valid @RequestBody List<Control> data)
			throws HandlerException {
		Boolean estado;
		try {
			service.actualizarTransaccional(data);
			estado = true;
		} catch (Exception e) {
			estado = false;
		}

		return new ResponseEntity<>(estado, HttpStatus.OK);
	}

}
