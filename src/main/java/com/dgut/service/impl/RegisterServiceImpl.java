package com.dgut.service.impl;

import com.dgut.dao.IRegisterInfoDao;
import com.dgut.domain.RegisterInfo;
import com.dgut.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private IRegisterInfoDao registerInfoDao;
	
	@Override
	public List<RegisterInfo> findAll(String date, String patientName) {
		List<RegisterInfo> registerInfoList = new ArrayList<RegisterInfo>();
		if (patientName.equals(""))
			patientName = null;
		if (date.equals("today")) {
			registerInfoList = registerInfoDao.findAllToday(patientName);
		} else if (date.equals("week")) {
			registerInfoList = registerInfoDao.findAllWeek(patientName);
		} else if (date.equals("month")) {
			registerInfoList = registerInfoDao.findAllMonth(patientName);
		} else if (date.equals("all")) {
			registerInfoList = registerInfoDao.findAll(patientName);
		}
		return registerInfoList;

	}

	@Override
	public Integer update(RegisterInfo registerInfo) {
		return registerInfoDao.updateRegisterInfo(registerInfo);
	}

	@Override
	public List<RegisterInfo> findByDoctor(String doctorName, String deptName) {
		return registerInfoDao.findByDoctor(doctorName, deptName);
	}

	@Override
	public Integer insertRegisterInfo(RegisterInfo registerInfo) {
		return registerInfoDao.insertRegisterInfo(registerInfo);
	}

	@Override
	public RegisterInfo findByRegistCode(Integer registCode) {
		return registerInfoDao.findByRegistCode(registCode);
	}

	@Override
	public RegisterInfo findByRegistCode() {
		return registerInfoDao.findByRegistCode(registerInfoDao.maxRegistCode());
	}

	@Override
	public RegisterInfo findConsultation(String doctorName, String deptName) {
		return registerInfoDao.findConsultation(doctorName, deptName);
	}

	@Override
	public Integer updateStatusEnd(Integer registCode) {
		return registerInfoDao.updateStatusEnd(registCode);
	}

	@Override
	public Integer updateStatusIng(Integer registCode) {
		return registerInfoDao.updateStatusIng(registCode);
	}

	@Override
	public Integer delete(Integer registCode) {
		
		return registerInfoDao.updateStatusEnd(registCode);
	}

	@Override
	public List<RegisterInfo> findByDoctorRecord(String doctorName, String deptName) {
		return registerInfoDao.findByDoctorRecord(doctorName,deptName);
	}
}
