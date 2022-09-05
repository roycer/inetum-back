package com.gregpalacios.builder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public ResponseEntity<Boolean> registrarData(@Valid @RequestBody List<FormularioData> data) throws Exception {
		Boolean estado;
		
		String primaryKey = null;
		String tableName = "";
		List<String> listaInputType = new ArrayList<String>();
		List<String> listaColumnas = new ArrayList<String>();
		List<String> listaValores = new ArrayList<String>();

		Integer id;
		try {
			
			List<FormularioData> detailForm = data.stream()
					.filter(o -> o.getControl().getSubmodulo() != null)
					.collect(Collectors.toList());
			if(!detailForm.isEmpty()) {
				primaryKey = detailForm.get(0).getControl().getSubmodulo().getColumnName();
			}

			List<FormularioData> headForm = data.stream()
					.filter(o -> o.getControl().getSubmodulo() == null)
					.collect(Collectors.toList());
			tableName = getParameter(headForm, listaInputType, listaColumnas, listaValores);
			id = em.registrarData2(tableName, listaInputType, listaColumnas, listaValores, primaryKey);
			
			listaInputType = new ArrayList<String>();
			listaColumnas = new ArrayList<String>();
			listaValores = new ArrayList<String>();
			
			if(!detailForm.isEmpty()) {
				String subModTableName = detailForm.get(0).getControl().getSubmodulo().getTableName();
				for (FormularioData form: detailForm){
					if(subModTableName != form.getControl().getSubmodulo().getTableName()) {
					    listaInputType.add("number");
					    listaColumnas.add(primaryKey);
					    listaValores.add(id.toString());
						em.registrarData2(subModTableName, listaInputType, listaColumnas, listaValores, null);
						listaInputType = new ArrayList<String>();
						listaColumnas = new ArrayList<String>();
						listaValores = new ArrayList<String>();
						subModTableName = "";
					}
					if(subModTableName == form.getControl().getSubmodulo().getTableName() || subModTableName.isEmpty()) {
						subModTableName = form.getControl().getSubmodulo().getTableName();
						listaInputType.add(form.getControl().getInputType());
						listaColumnas.add(form.getControl().getColumnName());
						listaValores.add(form.getColumnValue());
					}
				}
			    listaInputType.add("number");
			    listaColumnas.add(primaryKey);
			    listaValores.add(id.toString());
				em.registrarData2(subModTableName, listaInputType, listaColumnas, listaValores, null);
			}
			estado = true;
		} catch (Exception e) {
			estado = false;
		}

		return new ResponseEntity<Boolean>(estado, HttpStatus.CREATED);
	}

	String getParameter(List<FormularioData> formData,
			List<String> listaInputType,
			List<String> listaColumnas,
			List<String>  listaValores
			) {
		String tableName = "";
		for (FormularioData dato : formData) {
			tableName = dato.getModulo().getTableName();
			listaInputType.add(dato.getControl().getInputType());
			listaColumnas.add(dato.getControl().getColumnName());
			listaValores.add(dato.getColumnValue());
		}
		return tableName;
	}
	
}
