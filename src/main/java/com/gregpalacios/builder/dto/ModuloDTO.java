package com.gregpalacios.builder.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ModuloDTO {

	private Integer idModulo;

	private String key;

	private String label;

	private String tableName;

	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	private Date fechaReg;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getEstadoReg() {
		return estadoReg;
	}

	public void setEstadoReg(Integer estadoReg) {
		this.estadoReg = estadoReg;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	@Override
	public String toString() {
		return "ModuloDTO [idModulo=" + idModulo + ", key=" + key + ", label=" + label + ", tableName=" + tableName
				+ ", estadoReg=" + estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
