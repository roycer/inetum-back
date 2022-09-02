package com.gregpalacios.builder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uvw_tablas_negocio")
public class TablaNegocio {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "table_name")
	private String tableName;

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

	@Override
	public String toString() {
		return "TablaNegocio [id=" + id + ", tableName=" + tableName + "]";
	}
	
}
