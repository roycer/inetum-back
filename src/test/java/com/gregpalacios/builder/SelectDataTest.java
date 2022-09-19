package com.gregpalacios.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gregpalacios.builder.model.ControlOption;
import com.gregpalacios.builder.model.Modulo;
import com.gregpalacios.builder.model.TablaColumnasNegocio;
import com.gregpalacios.builder.model.TablaNegocio;
import com.gregpalacios.builder.service.IControlOptionService;
import com.gregpalacios.builder.service.IModuloService;
import com.gregpalacios.builder.service.ITablaColumnasNegocioService;
import com.gregpalacios.builder.service.ITablaNegocioService;

@SpringBootTest
public class SelectDataTest {

	@Autowired
	private IModuloService serviceModuloService;

	@Autowired
	private ITablaNegocioService serviceTablaNegocioService;
	
	@Test
	void testListModules() throws Exception {
		List<Modulo> lista = serviceModuloService.listar();
		assertThat(lista).size().isGreaterThan(0);

	} 
	
	@Test
	void testListBusinessTable() throws Exception {
		List<TablaNegocio> lista = serviceTablaNegocioService.listar();
		assertThat(lista).size().isGreaterThan(0);
	}
	
	
}
