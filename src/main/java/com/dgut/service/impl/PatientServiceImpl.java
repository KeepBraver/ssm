package com.dgut.service.impl;

import com.dgut.dao.IPatientInfoDao;
import com.dgut.domain.PatientInfo;
import com.dgut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientInfoDao patientInfoDao;

	@Override
	public PatientInfo findByIdNumber(String idNumber) {
		return patientInfoDao.findByIdNumber(idNumber);
	}

	@Override
	public List<PatientInfo> findAllPatients() {
		return patientInfoDao.findAllPatients();
	}

	@Override
	public int insert(PatientInfo patient) {
		return patientInfoDao.insert(patient);
	}

	@Override
	public void update(PatientInfo patient) {
		patientInfoDao.update(patient);
	}
}
