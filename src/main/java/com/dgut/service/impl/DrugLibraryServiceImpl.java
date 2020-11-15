package com.dgut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgut.dao.IDrugLibraryDao;
import com.dgut.domain.DrugLibrary;
import com.dgut.service.IDrugLibraryService;

@Service("drugLibraryService")
public class DrugLibraryServiceImpl implements IDrugLibraryService {

	@Autowired
	private IDrugLibraryDao drugLibraryDao;
	@Override
	public List<DrugLibrary> findAll() {
		return drugLibraryDao.findAll();
	}
	@Override
	public Integer add(DrugLibrary drugLibrary) {
		return drugLibraryDao.insert(drugLibrary);
	}

}
