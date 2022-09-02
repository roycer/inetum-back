package com.gregpalacios.builder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.ControlOption;

public interface IControlOptionRepo extends IGenericRepo<ControlOption, Integer> {

	@Query("SELECT co FROM ControlOption co WHERE co.control.idControl =:idControl ORDER BY co.idControlOption ASC")
	List<ControlOption> findByIdControl(@Param("idControl") Integer idControl);

	@Query("SELECT co FROM ControlOption co WHERE co.control.key =:key ORDER BY co.idControlOption ASC")
	List<ControlOption> findByKeyControl(@Param("key") String key);

	@Query("SELECT co FROM ControlOption co WHERE co.key =:key")
	ControlOption findByKey(@Param("key") String key);
}
