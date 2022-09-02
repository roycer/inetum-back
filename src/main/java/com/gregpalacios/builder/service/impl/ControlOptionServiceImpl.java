package com.gregpalacios.builder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ControlOption> listarPorIdControl(Integer idControl) throws Exception {
		return repo.findByIdControl(idControl);
	}

	@Override
	public List<ControlOption> listarPorKeyControl(String key) throws Exception {
		return repo.findByKeyControl(key);
	}

	@Override
	public ControlOption listarPorKey(String key) throws Exception {
		return repo.findByKey(key);
	}

}
