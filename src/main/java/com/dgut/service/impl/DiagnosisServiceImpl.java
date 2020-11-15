package com.dgut.service.impl;

import com.dgut.dao.IDiagnosisInfoDao;
import com.dgut.domain.DiagnosisInfo;
import com.dgut.service.IDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diagnosisService")
public class DiagnosisServiceImpl implements IDiagnosisService {

	@Autowired
	private IDiagnosisInfoDao diagnosisInfoDao;

	@Override
	public Integer insertRegisterInfo(DiagnosisInfo diagnosisInfo) {
		return diagnosisInfoDao.insertDiagnosisInfo(diagnosisInfo);
	}

	@Override
	public DiagnosisInfo findByRegistCode(Integer registCode) {
		return diagnosisInfoDao.findByRegistCode(registCode);
	}

}
