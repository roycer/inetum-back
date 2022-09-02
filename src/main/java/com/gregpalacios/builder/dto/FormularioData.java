package com.gregpalacios.builder.dto;

import com.gregpalacios.builder.model.Control;
import com.gregpalacios.builder.model.Modulo;

public class FormularioData {

	private Modulo modulo;

	private Control control;

	private String columnValue;

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

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	@Override
	public String toString() {
		return "FormularioData [modulo=" + modulo + ", control=" + control + ", columnValue=" + columnValue + "]";
	}

}
