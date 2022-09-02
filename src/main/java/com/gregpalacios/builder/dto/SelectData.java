package com.gregpalacios.builder.dto;

public class SelectData {

	private String tableName;

	private String columnID;

	private String columnValue;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnID() {
		return columnID;
	}

	public void setColumnID(String columnID) {
		this.columnID = columnID;
	}

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	@Override
	public String toString() {
		return "SelectData [tableName=" + tableName + ", columnID=" + columnID + ", columnValue=" + columnValue + "]";
	}

}
