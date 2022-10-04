package com.gregpalacios.builder.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gregpalacios.builder.model.Modulo;
import com.gregpalacios.builder.model.SubModulo;

public class ControlDTO {

	private Integer idControl;

	private Modulo modulo;

	private SubModulo submodulo;

	private String key;

	private String label;

	private Integer required;

	private Integer order;

	private String controlType;

	private String inputType;

	private String gridClass;

	private String columnName;

	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	private Date fechaReg;

	public Integer getIdControl() {
		return idControl;
	}

	public void setIdControl(Integer idControl) {
		this.idControl = idControl;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public SubModulo getSubmodulo() {
		return submodulo;
	}

	public void setSubmodulo(SubModulo submodulo) {
		this.submodulo = submodulo;
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

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getGridClass() {
		return gridClass;
	}

	public void setGridClass(String gridClass) {
		this.gridClass = gridClass;
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
		return "ControlDTO [idControl=" + idControl + ", modulo=" + modulo + ", submodulo=" + submodulo + ", key=" + key
				+ ", label=" + label + ", required=" + required + ", order=" + order + ", controlType=" + controlType
				+ ", inputType=" + inputType + ", gridClass=" + gridClass + ", columnName=" + columnName
				+ ", estadoReg=" + estadoReg + ", fechaReg=" + fechaReg + "]";
	}
	
}
