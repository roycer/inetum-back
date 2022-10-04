package com.gregpalacios.builder.service.impl;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.repo.IGenericRepo;
import com.gregpalacios.builder.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T registrar(T t) throws HandlerException {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws HandlerException {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws HandlerException {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws HandlerException {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws HandlerException {
		getRepo().deleteById(id);
	}

}