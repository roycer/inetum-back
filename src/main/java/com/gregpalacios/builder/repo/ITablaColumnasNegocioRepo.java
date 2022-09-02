package com.gregpalacios.builder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.builder.model.TablaColumnasNegocio;

public interface ITablaColumnasNegocioRepo extends IGenericRepo<TablaColumnasNegocio, Long> {

	@Query("SELECT tcn FROM TablaColumnasNegocio tcn WHERE tcn.tableName =:tableName")
	List<TablaColumnasNegocio> findByTableName(@Param("tableName") String tableName);
}
