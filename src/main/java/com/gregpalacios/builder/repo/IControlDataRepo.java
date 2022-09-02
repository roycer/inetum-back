package com.gregpalacios.builder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.ControlData;

public interface IControlDataRepo extends IGenericRepo<ControlData, Integer> {

	@Query("SELECT co FROM ControlData co WHERE co.modulo.idModulo =:idModulo ORDER BY co.idControlData ASC")
	List<ControlData> findByIdModulo(@Param("idModulo") Integer idModulo);

	@Query("SELECT co FROM ControlData co WHERE co.modulo.key =:key ORDER BY co.idControlData ASC")
	List<ControlData> findByKeyModulo(@Param("key") String key);
}
