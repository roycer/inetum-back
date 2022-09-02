package com.gregpalacios.builder.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.Modulo;

public interface IModuloRepo extends IGenericRepo<Modulo, Integer> {

	@Query("SELECT mo FROM Modulo mo WHERE mo.key =:key")
	Modulo findByKey(@Param("key") String key);
}
