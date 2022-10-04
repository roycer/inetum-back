package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;

public interface ICRUD<T, ID> {

	T registrar(T t) throws HandlerException;

	T modificar(T t) throws HandlerException;

	List<T> listar() throws HandlerException;

	T listarPorId(ID id) throws HandlerException;

	void eliminar(ID id) throws HandlerException;
}