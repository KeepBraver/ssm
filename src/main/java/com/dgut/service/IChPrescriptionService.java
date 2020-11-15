package com.dgut.service;

import com.dgut.domain.ChPrescription;
import com.dgut.domain.FlowSheet;

import java.util.List;

public interface IChPrescriptionService {
	Integer insert(ChPrescription chPrescription);

	List<ChPrescription> findAll(Integer registCode);

	Integer delete(String id);

	void updateAccount(FlowSheet flowSheet);
}
