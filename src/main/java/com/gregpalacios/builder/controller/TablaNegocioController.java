package com.gregpalacios.builder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.builder.model.TablaNegocio;
import com.gregpalacios.builder.service.ITablaNegocioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tablas")
@Tag(name = "TablasNegocio Controller", description = "Operaciones para el manejo de las tablas del negocio")
public class TablaNegocioController {

	@Autowired
	private ITablaNegocioService service;

	@Operation(summary = "Listar todas las tablas del negocio")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<TablaNegocio>> listar() throws Exception {
		List<TablaNegocio> lista = service.listar();
		return new ResponseEntity<List<TablaNegocio>>(lista, HttpStatus.OK);
	}

}
