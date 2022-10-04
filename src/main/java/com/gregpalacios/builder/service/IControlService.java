package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.Control;

public interface IControlService extends ICRUD<Control, Integer> {

	List<Control> listarPorIdModulo(Integer idModulo) throws HandlerException;
	
	List<Control> listarPorKeyModulo(String key) throws HandlerException;
	
	Control listarPorKey(String key) throws HandlerException;
	
	void actualizarTransaccional(List<Control> datos) throws HandlerException;
}
