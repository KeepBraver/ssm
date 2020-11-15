package com.dgut.service;

import com.dgut.domain.RegisterInfo;

import java.util.List;

public interface IRegisterService {
	List<RegisterInfo> findAll(String date, String patientName);

	Integer update(RegisterInfo registerInfo);

	List<RegisterInfo> findByDoctor(String doctorName, String deptName);

	Integer insertRegisterInfo(RegisterInfo registerInfo);

	RegisterInfo findByRegistCode(Integer registCode);

	RegisterInfo findByRegistCode();

	RegisterInfo findConsultation(String doctorName, String deptName);

	public Integer updateStatusEnd(Integer registCode);

	public Integer updateStatusIng(Integer registCode);

	Integer delete(Integer registCode);

	List<RegisterInfo> findByDoctorRecord(String doctorName, String deptName);
}
