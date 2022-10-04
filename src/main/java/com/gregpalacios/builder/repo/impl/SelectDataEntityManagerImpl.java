package com.gregpalacios.builder.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gregpalacios.builder.dto.OptionData;
import com.gregpalacios.builder.dto.SelectData;

@Component
public class SelectDataEntityManagerImpl {

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<OptionData> listSelectData(SelectData data) {
		String s = "SELECT %s AS key, %s AS value FROM %s";
		String sql = String.format(s, data.getColumnID(), data.getColumnValue(), data.getTableName());

		List<OptionData> selectData = new ArrayList<>();
		List<Object[]> results = em.createNativeQuery(sql).getResultList();
		results.stream().forEach(result -> {
			Integer key = (Integer) result[0];
			String value = (String) result[1];
			OptionData dto = new OptionData();
			dto.setKey(Integer.toString(key));
			dto.setValue(value);
			selectData.add(dto);
		});

		return selectData;
	}
}
