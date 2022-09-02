package com.gregpalacios.builder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.Control;

public interface IControlRepo extends IGenericRepo<Control, Integer> {

	@Query("SELECT co FROM Control co WHERE co.modulo.idModulo =:idModulo ORDER BY co.order ASC")
	List<Control> findByIdModulo(@Param("idModulo") Integer idModulo);
	
	@Query("SELECT co FROM Control co WHERE co.modulo.key =:key ORDER BY co.order ASC")
	List<Control> findByKeyModulo(@Param("key") String key);
	
	@Query("SELECT co FROM Control co WHERE co.key =:key")
	Control findByKey(@Param("key") String key);
}
