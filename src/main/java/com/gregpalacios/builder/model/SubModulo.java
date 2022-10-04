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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gregpalacios.builder.dto.SubModuloDTO;

@Entity
@Where(clause = "estado_reg='1'")
@Table(name = "submodulo")
public class SubModulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSubModulo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_modulo", nullable = false, foreignKey = @ForeignKey(name = "FK_submodulo_modulo"))
	private Modulo modulo;

	@Column(name = "key", updatable = false, nullable = false)
	private String key;

	@Column(name = "label", nullable = false)
	private String label;

	@Column(name = "table_name", nullable = false)
	private String tableName;

	@Column(name = "column_name", nullable = false)
	private String columnName;

	@Column(name = "estado_reg", nullable = false)
	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	@Column(name = "fecha_reg", nullable = false)
	private Date fechaReg;

	public SubModulo() {
		super();
	}

	public SubModulo(@Valid SubModuloDTO dto) {
		this.idSubModulo = dto.getIdSubModulo();
		this.modulo = dto.getModulo();
		this.key = dto.getKey();
		this.label = dto.getLabel();
		this.tableName = dto.getTableName();
		this.columnName = dto.getColumnName();
		this.estadoReg = dto.getEstadoReg();
		this.fechaReg = dto.getFechaReg();
	}

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
		return "SubModulo [idSubModulo=" + idSubModulo + ", modulo=" + modulo + ", key=" + key + ", label=" + label
				+ ", tableName=" + tableName + ", columnName=" + columnName + ", estadoReg=" + estadoReg + ", fechaReg="
				+ fechaReg + "]";
	}

}
