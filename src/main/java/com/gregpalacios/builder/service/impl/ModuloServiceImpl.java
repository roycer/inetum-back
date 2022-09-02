package com.gregpalacios.builder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.model.Modulo;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.repo.IModuloRepo;
import com.gregpalacios.builder.service.IModuloService;

@Service
public class ModuloServiceImpl extends CRUDImpl<Modulo, Integer> implements IModuloService {

	@Autowired
	private IModuloRepo repo;
	
	@Override
	protected IGenericRepo<Modulo, Integer> getRepo() {
		return repo;
	}

	@Override
	public Modulo listarPorKey(String key) throws Exception {
		return repo.findByKey(key);
	}

}
