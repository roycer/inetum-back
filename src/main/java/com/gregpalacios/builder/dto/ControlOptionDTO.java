package com.gregpalacios.builder.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gregpalacios.builder.model.Control;

public class ControlOptionDTO {

	private Integer idControlOption;

	private Control control;

	private String key;

	private String value;

	private String tableName;

	private String columnName;

	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	private Date fechaReg;

	public Integer getIdControlOption() {
		return idControlOption;
	}

	public void setIdControlOption(Integer idControlOption) {
		this.idControlOption = idControlOption;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "ControlOptionDTO [idControlOption=" + idControlOption + ", control=" + control + ", key=" + key
				+ ", value=" + value + ", tableName=" + tableName + ", columnName=" + columnName + ", estadoReg="
				+ estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
