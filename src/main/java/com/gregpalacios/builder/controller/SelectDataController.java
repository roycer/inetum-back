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

import com.gregpalacios.builder.dto.OptionData;
import com.gregpalacios.builder.dto.SelectData;
import com.gregpalacios.builder.repo.impl.SelectDataEntityManagerImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/select")
@Tag(name = "SelectData Controller", description = "Operaciones para la carga dinámica de select")
public class SelectDataController {

	@Autowired
	private SelectDataEntityManagerImpl em;

	@Operation(summary = "Listar todos los datos del select")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente", content = @Content()),
			@ApiResponse(responseCode = "401", description = "No estas autorizado para ver este recurso", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content()) })
	@PostMapping
	public ResponseEntity<List<OptionData>> listar(@Valid @RequestBody SelectData data) {
		List<OptionData> lista = em.listSelectData(data);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
