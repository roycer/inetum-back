package com.gregpalacios.builder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.model.TablaNegocio;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.repo.ITablaNegocioRepo;
import com.gregpalacios.builder.service.ITablaNegocioService;

@Service
public class TablaNegocioServiceImpl extends CRUDImpl<TablaNegocio, Long> implements ITablaNegocioService {

	@Autowired
	private ITablaNegocioRepo repo;
	
	@Override
	protected IGenericRepo<TablaNegocio, Long> getRepo() {
		return repo;
	}

}
