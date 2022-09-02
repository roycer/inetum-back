package com.gregpalacios.builder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.SubModulo;

public interface ISubModuloRepo extends IGenericRepo<SubModulo, Integer> {

	@Query("SELECT sm FROM SubModulo sm WHERE sm.modulo.idModulo =:idModulo ORDER BY sm.idSubModulo ASC")
	List<SubModulo> findByIdModulo(@Param("idModulo") Integer idModulo);
	
	@Query("SELECT sm FROM SubModulo sm WHERE sm.modulo.key =:key ORDER BY sm.idSubModulo ASC")
	List<SubModulo> findByKeyModulo(@Param("key") String key);
	
	@Query("SELECT sm FROM SubModulo sm WHERE sm.key =:key")
	SubModulo findByKey(@Param("key") String key);
}
