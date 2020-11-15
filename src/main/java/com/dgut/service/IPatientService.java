package com.dgut.service;

import com.dgut.domain.PatientInfo;

import java.util.List;

public interface IPatientService {

	PatientInfo findByIdNumber(String idNumber);

	public List<PatientInfo> findAllPatients();

	public int insert(PatientInfo patient);

	public void update(PatientInfo patient);
}
