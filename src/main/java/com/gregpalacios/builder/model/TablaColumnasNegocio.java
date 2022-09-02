package com.gregpalacios.builder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uvw_tablas_columnas_negocio")
public class TablaColumnasNegocio {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "table_name")
	private String tableName;
	
	@Column(name = "column_name")
	private String columnName;
	
	@Column(name = "data_type")
	private String dataType;
	
	@Column(name = "is_nullable")
	private String isNullable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	@Override
	public String toString() {
		return "TablaColumnasNegocio [id=" + id + ", tableName=" + tableName + ", columnName=" + columnName
				+ ", dataType=" + dataType + ", isNullable=" + isNullable + "]";
	}

}
