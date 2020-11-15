package com.dgut.service;

import com.dgut.domain.InspectionItems;

import java.util.List;

public interface IInspectionItemsService {
	public int insertInspectionItems(InspectionItems inspectionItems);

	List<InspectionItems> findAll(Integer registCode);

	Integer deleteById(String id);
}
