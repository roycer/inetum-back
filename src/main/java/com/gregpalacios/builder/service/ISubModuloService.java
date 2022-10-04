package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.SubModulo;

public interface ISubModuloService extends ICRUD<SubModulo, Integer> {

	List<SubModulo> listarPorIdModulo(Integer idModulo) throws HandlerException;

	List<SubModulo> listarPorKeyModulo(String key) throws HandlerException;

	SubModulo listarPorKey(String key) throws HandlerException;
}
