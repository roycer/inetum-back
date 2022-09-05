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
		for (FormularioData dato : datos) {
			if (dato.getControl().getSubmodulo() == null) {
				if (!listaTablas.contains(dato.getModulo().getTableName())) {
					listaTablas.add(dato.getModulo().getTableName());
				}
			}
		}

		registrarCabecera(listaTablas.get(0), datos);

		String sequenceName = getNombreSecuencia(listaTablas.get(0));
		Integer sequenceValue = getValorSecuencia(sequenceName);

		registrarDetalle(datos, sequenceValue);

		return true;
	}

	public void registrarCabecera(String tableName, List<FormularioData> datos) throws Exception {
		List<String> listaValores = new ArrayList<String>();
		final StringBuilder columnas = new StringBuilder();
		final StringBuilder valores = new StringBuilder();
		Integer index = 0;
		for (FormularioData dato : datos) {
			if (dato.getControl().getSubmodulo() == null) {
				index++;

				listaValores.add(dato.getControl().getInputType() + "&" + dato.getColumnValue());

				columnas.append(dato.getControl().getColumnName() + ",");
				valores.append("?" + index + ",");
			}
		}

		String concatenatedColumnas = columnas.toString();
		String columasFinal = concatenatedColumnas.substring(0, concatenatedColumnas.length() - 1);

		String concatenatedValores = valores.toString();
		String valoresFinal = concatenatedValores.substring(0, concatenatedValores.length() - 1);

		String s = "INSERT INTO %s (%s) VALUES (%s)";
		String sql = String.format(s, tableName, columasFinal, valoresFinal);

		ejecutarInsert(sql, listaValores);
	}

	public void ejecutarInsert(String sql, List<String> listaValores) throws Exception {
		Query insert = em.createNativeQuery(sql);

		Integer index = 0;
		for (String valor : listaValores) {
			index++;

			String[] valorPartes = valor.split("&");
			String tipo = valorPartes[0];
			String value = valorPartes[1];

			if (tipo.equals("sequence") || tipo.equals("number") || tipo.equals("option")) {
				Integer number = Integer.parseInt(value);
				insert.setParameter(index, number);
			} else if (tipo.equals("date")) {
				DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sourceFormat.parse(value);
				insert.setParameter(index, date);
			} else {
				insert.setParameter(index, value.toString());
			}
		}

		insert.executeUpdate();
	}

	public String getNombreSecuencia(String tableName) throws Exception {
		String likeSequenceName = tableName.replace("dn_", "") + "_id";
		String sql = "SELECT sequence_name FROM information_schema.sequences WHERE sequence_name LIKE '%"
				+ likeSequenceName + "%'";

		Object result = em.createNativeQuery(sql).getSingleResult();

		return result.toString();
	}

	public Integer getValorSecuencia(String sequenceName) throws Exception {
		String sql = "SELECT last_value FROM " + sequenceName;

		Object result = em.createNativeQuery(sql).getSingleResult();

		return Integer.parseInt(result.toString());
	}

	public void registrarDetalle(List<FormularioData> datos, Integer secuencia) throws Exception {
		List<String> listaTablas = new ArrayList<String>();
		List<String> listaRelacionada = new ArrayList<String>();
		for (FormularioData dato : datos) {
			if (dato.getControl().getSubmodulo() != null) {
				if (!listaTablas.contains(dato.getControl().getSubmodulo().getTableName())) {
					listaTablas.add(dato.getControl().getSubmodulo().getTableName());
				}

				if (!listaRelacionada.contains(dato.getControl().getSubmodulo().getColumnName())) {
					listaRelacionada.add(dato.getControl().getSubmodulo().getColumnName());
				}
			}
		}

		for (String tabla : listaTablas) {
			registrarTablaDetalle(tabla, datos, listaRelacionada.get(0), secuencia);
		}
	}

	public void registrarTablaDetalle(String tableName, List<FormularioData> datos, String columnaName,
			Integer secuencia) throws Exception {
		List<String> listaValores = new ArrayList<String>();
		final StringBuilder columnas = new StringBuilder();
		final StringBuilder valores = new StringBuilder();

		listaValores.add("sequence" + "&" + secuencia);
		columnas.append(columnaName + ",");
		valores.append("?" + 1 + ",");

		Integer index = 1;
		for (FormularioData dato : datos) {
			if (dato.getControl().getSubmodulo() != null) {
				if (dato.getControl().getSubmodulo().getTableName().contains(tableName)) {
					index++;

					listaValores.add(dato.getControl().getInputType() + "&" + dato.getColumnValue());

					columnas.append(dato.getControl().getColumnName() + ",");
					valores.append("?" + index + ",");
				}
			}
		}

		String concatenatedColumnas = columnas.toString();
		String columasFinal = concatenatedColumnas.substring(0, concatenatedColumnas.length() - 1);

		String concatenatedValores = valores.toString();
		String valoresFinal = concatenatedValores.substring(0, concatenatedValores.length() - 1);

		String s = "INSERT INTO %s (%s) VALUES (%s)";
		String sql = String.format(s, tableName, columasFinal, valoresFinal);

		ejecutarInsert(sql, listaValores);
	}
}
