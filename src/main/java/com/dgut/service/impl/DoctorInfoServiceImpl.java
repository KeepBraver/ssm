package com.dgut.service.impl;

import com.dgut.dao.IDoctorInfoDao;
import com.dgut.domain.DoctorInfo;
import com.dgut.service.IDoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("doctorService")
public class DoctorInfoServiceImpl implements IDoctorInfoService {

	@Autowired
	private IDoctorInfoDao doctorInfoDao;

	@Override
	public Integer findByNameAndDept(String deptName, String doctorName) {
		return doctorInfoDao.findByNameAndDept(deptName, doctorName);
	}

	@Override
	public DoctorInfo findById(Integer doctorId) {
		return doctorInfoDao.findById(doctorId);
	}

	@Override
	public List<DoctorInfo> findAll() {
		return doctorInfoDao.findAll();
	}

	@Override
	public Integer update(DoctorInfo doctorInfo) {
		int result;
		if (doctorInfo.getDoctorId() != null && doctorInfo.getDoctorId() != 0)
			result = doctorInfoDao.update(doctorInfo);
		else
			result = doctorInfoDao.insert(doctorInfo);
		return null;
	}
}
