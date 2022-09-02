package com.gregpalacios.builder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregpalacios.builder.model.ControlData;
import com.gregpalacios.builder.repo.IControlDataRepo;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.service.IControlDataService;

@Service
public class ControlDataServiceImpl extends CRUDImpl<ControlData, Integer> implements IControlDataService {

	@Autowired
	private IControlDataRepo repo;

	@Override
	protected IGenericRepo<ControlData, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<ControlData> listarPorIdModulo(Integer idModulo) throws Exception {
		return repo.findByIdModulo(idModulo);
	}

	@Override
	public List<ControlData> listarPorKeyModulo(String key) throws Exception {
		return repo.findByKeyModulo(key);
	}

	@Transactional
	@Override
	public void registrarTransaccional(List<ControlData> datos) throws Exception {
		for (ControlData data : datos) {
			repo.save(data);
		}
	}

}
