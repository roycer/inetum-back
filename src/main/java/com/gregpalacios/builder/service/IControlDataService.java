package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.model.ControlData;

public interface IControlDataService extends ICRUD<ControlData, Integer> {

	List<ControlData> listarPorIdModulo(Integer idModulo) throws Exception;

	List<ControlData> listarPorKeyModulo(String key) throws Exception;

	void registrarTransaccional(List<ControlData> datos) throws Exception;
}
