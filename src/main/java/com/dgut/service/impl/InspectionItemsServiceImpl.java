package com.dgut.service.impl;

import com.dgut.dao.IInspectionItemsDao;
import com.dgut.domain.InspectionItems;
import com.dgut.service.IInspectionItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inspectionItemsService")
public class InspectionItemsServiceImpl implements IInspectionItemsService {

	@Autowired
	private IInspectionItemsDao iInspectionItemsDao;

	@Override
	public int insertInspectionItems(InspectionItems inspectionItems) {
		return iInspectionItemsDao.insertInspectionItems(inspectionItems);
	}

	@Override
	public List<InspectionItems> findAll(Integer registCode) {
		return iInspectionItemsDao.findByRegistCode(registCode);
	}

	@Override
	public Integer deleteById(String id) {
		return iInspectionItemsDao.deleteById(id);
	}
}
