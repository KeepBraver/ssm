package com.dgut.service.impl;

import com.dgut.dao.IDrugLibraryDao;
import com.dgut.dao.IWmPrescriptionDao;
import com.dgut.domain.FlowSheet;
import com.dgut.domain.WmPrescription;
import com.dgut.service.IWmPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wmPrescriptionService")
public class WmPrescriptionServiceImpl implements IWmPrescriptionService {
	@Autowired
	private IWmPrescriptionDao wmPrescriptionDao;
	
	@Autowired
	private IDrugLibraryDao drugLibraryDao;

	@Override
	public Integer insert(WmPrescription wmPrescription) {
		return wmPrescriptionDao.insert(wmPrescription);
	}

	@Override
	public List<WmPrescription> findAll(Integer registCode) {
		return wmPrescriptionDao.findByRegistCode(registCode);
	}

	@Override
	public Integer delete(String id) {
		return wmPrescriptionDao.delete(id);
	}

	@Override
	public void updateAccount(FlowSheet flowSheet) {
		WmPrescription wmPrescription = wmPrescriptionDao.findById(flowSheet.getChargeTypeId());
		if(flowSheet.getRetreat().equals("收费")) {		
			drugLibraryDao.charge(wmPrescription.getDrugName(), wmPrescription.getTotal());	
		}else {
			drugLibraryDao.refund(wmPrescription.getDrugName(), wmPrescription.getTotal());
		}
	}
}
