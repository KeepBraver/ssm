package com.dgut.service;

import com.dgut.domain.DoctorInfo;

import java.util.List;

public interface IDoctorInfoService {

	Integer findByNameAndDept(String deptName, String doctorName);

	DoctorInfo findById(Integer doctorId);

	List<DoctorInfo> findAll();

	Integer update(DoctorInfo doctorInfo);
}
