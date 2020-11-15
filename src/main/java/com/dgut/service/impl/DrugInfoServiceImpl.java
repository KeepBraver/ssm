package com.dgut.service.impl;

import com.dgut.dao.IDrugInfoDao;
import com.dgut.domain.DrugInfo;
import com.dgut.service.IDrugInfoService;
import com.dgut.utils.MajorKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("drugInfoService")
public class DrugInfoServiceImpl implements IDrugInfoService {

	@Autowired
	private IDrugInfoDao drugInfoDao;

	@Override
	public List<DrugInfo> findLikeDrugName(String drugName) {
		return drugInfoDao.findLikeDrugName("%" + drugName + "%");
	}

	@Override
	public List<DrugInfo> findAll() {
		return drugInfoDao.findAll();
	}

	@Override
	public Integer delete(String id) {
		return drugInfoDao.delete(id);
	}

	@Override
	public Integer update(DrugInfo drugInfo) {
		Integer result;
		if (drugInfo.getDrugCode() != null && drugInfo.getDrugCode() != "")
			result = drugInfoDao.update(drugInfo);
		else {
			drugInfo.setDrugCode(MajorKey.createPK());
			result = drugInfoDao.insert(drugInfo);
		}
		return result;
	}
}
