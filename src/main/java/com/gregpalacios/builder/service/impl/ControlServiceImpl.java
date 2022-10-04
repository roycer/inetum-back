package com.gregpalacios.builder.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.Control;
import com.gregpalacios.builder.repo.IControlRepo;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.service.IControlService;

@Service
public class ControlServiceImpl extends CRUDImpl<Control, Integer> implements IControlService {

	@Autowired
	private IControlRepo repo;

	@Override
	protected IGenericRepo<Control, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Control> listarPorIdModulo(Integer idModulo) throws HandlerException {
		return repo.findByIdModulo(idModulo);
	}

	@Override
	public List<Control> listarPorKeyModulo(String key) throws HandlerException {
		return repo.findByKeyModulo(key);
	}

	@Override
	public Control listarPorKey(String key) throws HandlerException {
		return repo.findByKey(key);
	}

	@Transactional
	@Override
	public void actualizarTransaccional(List<Control> datos) throws HandlerException {
		for (Control data : datos) {
			repo.save(data);
		}
	}

}
