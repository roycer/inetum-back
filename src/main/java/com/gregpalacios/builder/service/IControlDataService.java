package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.ControlData;

public interface IControlDataService extends ICRUD<ControlData, Integer> {

	List<ControlData> listarPorIdModulo(Integer idModulo) throws HandlerException;

	List<ControlData> listarPorKeyModulo(String key) throws HandlerException;

	void registrarTransaccional(List<ControlData> datos) throws HandlerException;
}
