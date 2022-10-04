package com.gregpalacios.builder.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gregpalacios.builder.model.Modulo;

public class SubModuloDTO {

	private Integer idSubModulo;

	private Modulo modulo;

	private String key;

	private String label;

	private String tableName;

	private String columnName;

	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	private Date fechaReg;

	public Integer getIdSubModulo() {
		return idSubModulo;
	}

	public void setIdSubModulo(Integer idSubModulo) {
		this.idSubModulo = idSubModulo;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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
		return "SubModuloDTO [idSubModulo=" + idSubModulo + ", modulo=" + modulo + ", key=" + key + ", label=" + label
				+ ", tableName=" + tableName + ", columnName=" + columnName + ", estadoReg=" + estadoReg + ", fechaReg="
				+ fechaReg + "]";
	}

}
