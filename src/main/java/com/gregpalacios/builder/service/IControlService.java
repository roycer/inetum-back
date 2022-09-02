package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.model.Control;

public interface IControlService extends ICRUD<Control, Integer> {

	List<Control> listarPorIdModulo(Integer idModulo) throws Exception;
	
	List<Control> listarPorKeyModulo(String key) throws Exception;
	
	Control listarPorKey(String key) throws Exception;
	
	void actualizarTransaccional(List<Control> datos) throws Exception;
}
