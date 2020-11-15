package com.dgut.service;

import com.dgut.domain.DiagnosisInfo;

public interface IDiagnosisService {
	Integer insertRegisterInfo(DiagnosisInfo diagnosisInfo);

	public DiagnosisInfo findByRegistCode(Integer registCode);

}
