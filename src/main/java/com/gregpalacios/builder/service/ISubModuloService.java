package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.model.SubModulo;

public interface ISubModuloService extends ICRUD<SubModulo, Integer> {

	List<SubModulo> listarPorIdModulo(Integer idModulo) throws Exception;

	List<SubModulo> listarPorKeyModulo(String key) throws Exception;

	SubModulo listarPorKey(String key) throws Exception;
}
