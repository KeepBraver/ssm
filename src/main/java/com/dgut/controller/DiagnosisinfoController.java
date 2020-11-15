package com.dgut.controller;

import com.dgut.domain.DiagnosisInfo;
import com.dgut.model.ResultModel;
import com.dgut.service.IDiagnosisService;
import com.dgut.utils.MajorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("diagnosis")
@ResponseBody
public class DiagnosisinfoController {

	@Autowired
	private IDiagnosisService diagnosisService;

	@PostMapping("update")
	public ResultModel update(DiagnosisInfo diagnosisinfo) {
		diagnosisinfo.setDiagnosticDate(new Date());
		if (diagnosisinfo.getDiagnosisCode() == null) {
			diagnosisinfo.setDiagnosisCode(MajorKey.createPK());
		}
		diagnosisService.insertRegisterInfo(diagnosisinfo);
		return new ResultModel();
	}

	@GetMapping("findByRegistCode")
	public Object findByRegistCode(Integer registCode) {
		return diagnosisService.findByRegistCode(registCode);
	}

}
