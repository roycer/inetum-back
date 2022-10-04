package com.gregpalacios.builder.service;

import java.util.List;

import com.gregpalacios.builder.exception.HandlerException;
import com.gregpalacios.builder.model.ControlOption;

public interface IControlOptionService extends ICRUD<ControlOption, Integer> {

	List<ControlOption> listarPorIdControl(Integer idControl) throws HandlerException;

	List<ControlOption> listarPorKeyControl(String key) throws HandlerException;

	ControlOption listarPorKey(String key) throws HandlerException;
}
