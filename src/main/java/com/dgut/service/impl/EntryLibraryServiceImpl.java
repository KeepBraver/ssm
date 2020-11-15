package com.dgut.service.impl;

import com.dgut.dao.IDrugEntryOrderDao;
import com.dgut.dao.IDrugLibraryDao;
import com.dgut.dao.IEntryLibraryDao;
import com.dgut.domain.DrugEntryOrder;
import com.dgut.domain.EntryLibrary;
import com.dgut.service.IEntryLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryLibraryService")
public class EntryLibraryServiceImpl implements IEntryLibraryService {

	@Autowired
	private IEntryLibraryDao entryLibraryDao;

	@Autowired
	private IDrugEntryOrderDao drugEntryOrderDao;

	@Autowired
	private IDrugLibraryDao drugLibraryDao;

	@Override
	public Integer insert(EntryLibrary entryLibrary) {
		return entryLibraryDao.insert(entryLibrary);
	}

	@Override
	public List<EntryLibrary> findByName(String drugName) {
		return entryLibraryDao.findByName("%" + drugName + "%");
	}

	@Override
	public EntryLibrary findById(Integer id) {
		return entryLibraryDao.findById(id);
	}

	@Override
	public EntryLibrary findMax() {
		return entryLibraryDao.findMax();
	}

	@Override
	public Integer updateStatus(Integer id) {
		List<DrugEntryOrder> drugEntryOrderList = drugEntryOrderDao.findByEntryLibraryId(id);
		for (int i = 0; i < drugEntryOrderList.size(); i++) {
			String drugCode = drugEntryOrderList.get(i).getDrugCode();
			Integer entryNum = drugEntryOrderList.get(i).getEntryNum();
			drugLibraryDao.updateLibraryNum(drugCode, entryNum);

		}
		return entryLibraryDao.updateStatus(id);
	}

	@Override
	public List<EntryLibrary> findAll() {
		return entryLibraryDao.findAll();
	}
}
