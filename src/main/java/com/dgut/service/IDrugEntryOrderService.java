package com.dgut.service;

import java.util.List;

import com.dgut.domain.DrugEntryOrder;

public interface IDrugEntryOrderService {

	Integer insert(DrugEntryOrder drugEntryOrder);

	List<DrugEntryOrder> findByEntryLibraryId(Integer id);

	Integer delete(String id);
}
