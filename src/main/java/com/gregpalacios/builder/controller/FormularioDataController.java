package com.gregpalacios.builder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.builder.dto.FormularioData;
import com.gregpalacios.builder.repo.impl.FormularioDataEntityManagerImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/formulario")
@Tag(name = "FormularioData Controller", description = "Operaciones para el manejo dinámico de formularios")
public class FormularioDataController {

	@Autowired
	private FormularioDataEntityManagerImpl em;

	@Operation(summary = "Registrar datos del formulario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Registrado con éxito.", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para acceder a este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content()) })
	@PostMapping
	public ResponseEntity<Boolean> registrarData(@Valid @RequestBody List<FormularioData> data) {
		Boolean estado;
		try {
			em.registrarData(data);
			estado = true;
		} catch (Exception e) {
			estado = false;
		}

		return new ResponseEntity<>(estado, HttpStatus.CREATED);
	}

}
