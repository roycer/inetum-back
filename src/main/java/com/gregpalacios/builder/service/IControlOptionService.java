package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.model.ControlOption;

public interface IControlOptionService extends ICRUD<ControlOption, Integer> {

	List<ControlOption> listarPorIdControl(Integer idControl) throws Exception;

	List<ControlOption> listarPorKeyControl(String key) throws Exception;

	ControlOption listarPorKey(String key) throws Exception;
}
