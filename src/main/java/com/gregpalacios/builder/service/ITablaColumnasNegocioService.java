package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.TablaColumnasNegocio;

public interface ITablaColumnasNegocioService extends ICRUD<TablaColumnasNegocio, Long> {

	List<TablaColumnasNegocio> listarPorTableName(String tableName) throws HandlerException;
}
