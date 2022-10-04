package com.gregpalacios.builder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.SubModulo;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.repo.ISubModuloRepo;
import com.gregpalacios.builder.service.ISubModuloService;

@Service
public class SubModuloServiceImpl extends CRUDImpl<SubModulo, Integer> implements ISubModuloService {

	@Autowired
	private ISubModuloRepo repo;

	@Override
	protected IGenericRepo<SubModulo, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<SubModulo> listarPorIdModulo(Integer idModulo) throws HandlerException {
		return repo.findByIdModulo(idModulo);
	}

	@Override
	public List<SubModulo> listarPorKeyModulo(String key) throws HandlerException {
		return repo.findByKeyModulo(key);
	}

	@Override
	public SubModulo listarPorKey(String key) throws HandlerException {
		return repo.findByKey(key);
	}

}
