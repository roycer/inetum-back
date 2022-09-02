package com.gregpalacios.builder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.builder.model.TablaColumnasNegocio;
import com.gregpalacios.builder.service.ITablaColumnasNegocioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/columnas")
@Tag(name = "TablaColumnasNegocio Controller", description = "Operaciones para el manejo de las tablas/columnas del negocio")
public class TablaColumnasNegocioController {

	@Autowired
	private ITablaColumnasNegocioService service;

	@Operation(summary = "Listar todas las tablas/columnas del negocio")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping
	public ResponseEntity<List<TablaColumnasNegocio>> listar() throws Exception {
		List<TablaColumnasNegocio> lista = service.listar();
		return new ResponseEntity<List<TablaColumnasNegocio>>(lista, HttpStatus.OK);
	}

	@Operation(summary = "Listar las columnas por nombre de la tabla")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@GetMapping("/tabla/{tableName}")
	public ResponseEntity<List<TablaColumnasNegocio>> listarPorTableName(@PathVariable("tableName") String tableName)
			throws Exception {
		List<TablaColumnasNegocio> lista = service.listarPorTableName(tableName);
		return new ResponseEntity<List<TablaColumnasNegocio>>(lista, HttpStatus.OK);
	}

}
