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
@Table(name = "control_option")
public class ControlOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idControlOption;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_control", nullable = false, foreignKey = @ForeignKey(name = "FK_control_option_control"))
	private Control control;

	@Column(name = "key", updatable = false, nullable = false)
	private String key;

	@Column(name = "valor", nullable = false)
	private String value;
	
	@Column(name = "table_name", nullable = false)
	private String tableName;
	
	@Column(name = "column_name", nullable = false)
	private String columnName;

	@Column(name = "estado_reg", nullable = false)
	private Integer estadoReg;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Lima")
	@Column(name = "fecha_reg", nullable = false)
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
		return "ControlOption [idControlOption=" + idControlOption + ", control=" + control + ", key=" + key
				+ ", value=" + value + ", tableName=" + tableName + ", columnName=" + columnName + ", estadoReg="
				+ estadoReg + ", fechaReg=" + fechaReg + "]";
	}

}
