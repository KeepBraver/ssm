package com.dgut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgut.dao.IDrugEntryOrderDao;
import com.dgut.domain.DrugEntryOrder;
import com.dgut.service.IDrugEntryOrderService;

@Service("drugEntryOrderService")
public class DrugEntryOrderServiceImpl implements IDrugEntryOrderService {

	@Autowired
	private IDrugEntryOrderDao drugEntryOrderDao;

	@Override
	public Integer insert(DrugEntryOrder drugEntryOrder) {
		return drugEntryOrderDao.insert(drugEntryOrder);
	}

	@Override
	public List<DrugEntryOrder> findByEntryLibraryId(Integer id) {
		return drugEntryOrderDao.findByEntryLibraryId(id);
	}

	@Override
	public Integer delete(String id) {
		return drugEntryOrderDao.delete(id);
	}

}
