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
@Table(name = "control_data")
public class ControlData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idControlData;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_modulo", nullable = false, foreignKey = @ForeignKey(name = "FK_control_data_modulo"))
	private Modulo modulo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_control", nullable = false, foreignKey = @ForeignKey(name = "FK_control_data_control"))
	private Control control;

	@Column(name = "key", updatable = false, nullable = false)
	private String key;

	@Column(name = "valor", nullable = false)
	private String value;

	@Column(name = "estado_reg", nullable = false)
	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	@Column(name = "fecha_reg", nullable = false)
	private Date fechaReg;

	public Integer getIdControlData() {
		return idControlData;
	}

	public void setIdControlData(Integer idControlData) {
		this.idControlData = idControlData;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
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
		return "ControlData [idControlData=" + idControlData + ", modulo=" + modulo + ", control=" + control + ", key="
				+ key + ", value=" + value + ", estadoReg=" + estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
