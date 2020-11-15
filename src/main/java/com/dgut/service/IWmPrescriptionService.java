package com.dgut.service;

import com.dgut.domain.FlowSheet;
import com.dgut.domain.WmPrescription;

import java.util.List;

public interface IWmPrescriptionService {

	Integer insert(WmPrescription wmPrescription);

	public List<WmPrescription> findAll(Integer registCode);

	public Integer delete(String id);

	void updateAccount(FlowSheet flowSheet);
}
