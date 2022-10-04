package com.gregpalacios.builder;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gregpalacios.builder.model.Control;
import com.gregpalacios.builder.model.Modulo;
import com.gregpalacios.builder.repo.IControlRepo;
import com.gregpalacios.builder.repo.IModuloRepo;

@SpringBootTest
class BuilderApplicationTests {

	@Autowired
	private IModuloRepo moduloRepo;

	@Autowired
	private IControlRepo controlRepo;

	private String keyModulo = "12152ce0-604b-4d74-b440-3802f9908302";

	@Test
	void testModuloFindAll() {
		List<Modulo> modulos = moduloRepo.findAll();
		Assertions.assertFalse(modulos.isEmpty());
	}

	@Test
	void testModuloFindById() {
		Optional<Modulo> modulo = moduloRepo.findById(1);
		Assertions.assertTrue(modulo.isPresent());
		Assertions.assertEquals(keyModulo, modulo.orElseThrow(null).getKey());
	}

	@Test
	void testModuloFindByKey() {
		Optional<Modulo> modulo = Optional.ofNullable(moduloRepo.findByKey(keyModulo));
		Assertions.assertTrue(modulo.isPresent());
		Assertions.assertEquals(1, modulo.orElseThrow(null).getIdModulo());
	}

	@Test
	void tesControlesFindByKeyModulo() {
		List<Control> controles = controlRepo.findByKeyModulo(keyModulo);
		Assertions.assertFalse(controles.isEmpty());
	}

}
