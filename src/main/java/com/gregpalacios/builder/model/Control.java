package com.gregpalacios.builder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Where(clause = "estado_reg='1'")
@Table(name = "control")
public class Control {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idControl;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_modulo", nullable = false, foreignKey = @ForeignKey(name = "FK_control_modulo"))
	private Modulo modulo;

	@ManyToOne
	@JoinColumn(name = "id_sub_modulo", nullable = true, foreignKey = @ForeignKey(name = "FK_control_submodulo"))
	private SubModulo submodulo;

	@Column(name = "key", updatable = false, nullable = false)
	private String key;

	@Column(name = "label", nullable = false)
	private String label;

	@Column(name = "obligatorio", nullable = false)
	private Integer required;

	@Column(name = "orden", nullable = false)
	private Integer order;

	@Column(name = "control_type", nullable = false)
	private String controlType;

	@Column(name = "input_type", nullable = false)
	private String inputType;

	@Column(name = "grid_class", nullable = false)
	private String gridClass;

	@Column(name = "column_name", nullable = false)
	private String columnName;

	@Column(name = "estado_reg", nullable = false)
	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	@Column(name = "fecha_reg", nullable = false)
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
		return "Control [idControl=" + idControl + ", modulo=" + modulo + ", submodulo=" + submodulo + ", key=" + key
				+ ", label=" + label + ", required=" + required + ", order=" + order + ", controlType=" + controlType
				+ ", inputType=" + inputType + ", gridClass=" + gridClass + ", columnName=" + columnName
				+ ", estadoReg=" + estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
