package com.gregpalacios.builder.repo.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gregpalacios.builder.dto.FormularioData;

@Component
public class FormularioDataEntityManagerImpl {

	@Autowired
	EntityManager em;

	@Transactional
	public Boolean registrarData(List<FormularioData> datos) throws Exception {
		List<String> listaTablas = new ArrayList<String>();
		List<String> listaValores = new ArrayList<String>();
		final StringBuilder columnas = new StringBuilder();
		final StringBuilder valores = new StringBuilder();
		Integer index = 0;
		for (FormularioData dato : datos) {
			if (dato.getControl().getSubmodulo() == null) {
				index++;

				listaTablas.add(dato.getModulo().getTableName());
				listaValores.add(dato.getControl().getInputType() + "-" + dato.getColumnValue());

				columnas.append(dato.getControl().getColumnName() + ",");
				valores.append("?" + index + ",");
			}
		}

		String concatenatedColumnas = columnas.toString();
		String columasFinal = concatenatedColumnas.substring(0, concatenatedColumnas.length() - 1);

		String concatenatedValores = valores.toString();
		String valoresFinal = concatenatedValores.substring(0, concatenatedValores.length() - 1);

		String s = "INSERT INTO %s (%s) VALUES (%s)";
		String sql = String.format(s, listaTablas.get(0), columasFinal, valoresFinal);

		Query insert = em.createNativeQuery(sql);

		Integer index2 = 0;
		for (String valor : listaValores) {
			index2++;

			String[] valorPartes = valor.split("-");
			String tipo = valorPartes[0];
			String value = valorPartes[1];

			if (tipo.equals("number") || tipo.equals("option")) {
				Integer number = Integer.parseInt(value);
				insert.setParameter(index2, number);
			} else if (tipo.equals("date")) {
				DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sourceFormat.parse(value);
				insert.setParameter(index2, date);
			} else {
				insert.setParameter(index2, value.toString());
			}
		}

		insert.executeUpdate();

		return true;
	}
}
