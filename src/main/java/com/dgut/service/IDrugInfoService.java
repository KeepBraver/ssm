package com.dgut.service;

import com.dgut.domain.DrugInfo;

import java.util.List;

public interface IDrugInfoService {
	public List<DrugInfo> findLikeDrugName(String drugName);

	List<DrugInfo> findAll();

	Integer delete(String id);

	Integer update(DrugInfo drugInfo);
}
