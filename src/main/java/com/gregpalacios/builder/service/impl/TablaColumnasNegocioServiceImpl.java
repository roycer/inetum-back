package com.gregpalacios.builder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.TablaColumnasNegocio;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.repo.ITablaColumnasNegocioRepo;
import com.gregpalacios.builder.service.ITablaColumnasNegocioService;

@Service
public class TablaColumnasNegocioServiceImpl extends CRUDImpl<TablaColumnasNegocio, Long> implements ITablaColumnasNegocioService {

	@Autowired
	private ITablaColumnasNegocioRepo repo;
	
	@Override
	protected IGenericRepo<TablaColumnasNegocio, Long> getRepo() {
		return repo;
	}

	@Override
	public List<TablaColumnasNegocio> listarPorTableName(String tableName) throws HandlerException {
		return repo.findByTableName(tableName);
	}

}
