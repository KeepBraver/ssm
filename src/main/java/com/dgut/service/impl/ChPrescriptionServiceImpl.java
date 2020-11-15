package com.dgut.service.impl;

import com.dgut.dao.IChPrescriptionDao;
import com.dgut.dao.IDrugLibraryDao;
import com.dgut.domain.ChPrescription;
import com.dgut.domain.FlowSheet;
import com.dgut.domain.WmPrescription;
import com.dgut.service.IChPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chPrescriptionService")
public class ChPrescriptionServiceImpl implements IChPrescriptionService {

	@Autowired
	private IChPrescriptionDao chPrescriptionDao;
	
	@Autowired IDrugLibraryDao drugLibraryDao;

	@Override
	public Integer insert(ChPrescription chPrescription) {
		return chPrescriptionDao.insert(chPrescription);
	}

	@Override
	public List<ChPrescription> findAll(Integer registCode) {
		return chPrescriptionDao.findAll(registCode);
	}

	@Override
	public Integer delete(String id) {
		return chPrescriptionDao.delete(id);
	}

	@Override
	public void updateAccount(FlowSheet flowSheet) {
		ChPrescription chPrescription = chPrescriptionDao.findById(flowSheet.getChargeTypeId());
		if(flowSheet.getRetreat().equals("收费")) {		
			drugLibraryDao.charge(chPrescription.getDrugName(), chPrescription.getTotal());	
		}else {
			drugLibraryDao.refund(chPrescription.getDrugName(), chPrescription.getTotal());
		}
	}
}
