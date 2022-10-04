package com.gregpalacios.builder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.ControlOption;
import com.gregpalacios.builder.repo.IControlOptionRepo;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.service.IControlOptionService;

@Service
public class ControlOptionServiceImpl extends CRUDImpl<ControlOption, Integer> implements IControlOptionService {

	@Autowired
	private IControlOptionRepo repo;

	@Override
	protected IGenericRepo<ControlOption, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<ControlOption> listarPorIdControl(Integer idControl) throws HandlerException {
		return repo.findByIdControl(idControl);
	}

	@Override
	public List<ControlOption> listarPorKeyControl(String key) throws HandlerException {
		return repo.findByKeyControl(key);
	}

	@Override
	public ControlOption listarPorKey(String key) throws HandlerException {
		return repo.findByKey(key);
	}

}
