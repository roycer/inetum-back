package com.gregpalacios.builder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gregpalacios.builder.dto.ModuloDTO;

@Entity
@Where(clause = "estado_reg='1'")
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModulo;

	@Column(name = "key", updatable = false, nullable = false)
	private String key;

	@Column(name = "label", nullable = false)
	private String label;

	@Column(name = "table_name", nullable = false)
	private String tableName;

	@Column(name = "estado_reg", nullable = false)
	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	@Column(name = "fecha_reg", nullable = false)
	private Date fechaReg;

	public Modulo() {
		super();
	}

	public Modulo(@Valid ModuloDTO dto) {
		this.idModulo = dto.getIdModulo();
		this.key = dto.getKey();
		this.label = dto.getLabel();
		this.tableName = dto.getTableName();
		this.estadoReg = dto.getEstadoReg();
		this.fechaReg = dto.getFechaReg();
	}

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
		return "Modulo [idModulo=" + idModulo + ", key=" + key + ", label=" + label + ", tableName=" + tableName
				+ ", estadoReg=" + estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
