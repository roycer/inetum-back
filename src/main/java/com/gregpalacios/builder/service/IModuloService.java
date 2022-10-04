package com.gregpalacios.builder.service;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.Modulo;

public interface IModuloService extends ICRUD<Modulo, Integer> {

	Modulo listarPorKey(String key) throws HandlerException;
}
