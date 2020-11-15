package com.dgut.controller;

import com.dgut.domain.PatientInfo;
import com.dgut.domain.RegisterInfo;
import com.dgut.model.ResultModel;
import com.dgut.service.IPatientService;
import com.dgut.utils.AgeUtil;
import com.dgut.utils.CaseNum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("patient")
@ResponseBody
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@GetMapping("findAll")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(patientService.findAllPatients());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("findByIdNumber")
	public ResultModel findByIdNumber(String idNumber) {
		PatientInfo patientInfo = patientService.findByIdNumber(idNumber);
		if (patientInfo == null) {
			return new ResultModel(0, "没有该患者");
		} else {
			return new ResultModel(1L, patientInfo);
		}
	}

	@PostMapping("add")
	public ResultModel add(PatientInfo patientInfo) throws Exception {
		patientInfo.setCaseNum(CaseNum.creatCaseNum());
		patientInfo.setAge(AgeUtil.caculateAge(patientInfo.getBirthday()));
		patientService.insert(patientInfo);
		return new ResultModel();
	}

	@PostMapping("update")
	public ResultModel update(PatientInfo patientInfo) throws Exception {
		patientInfo.setAge(AgeUtil.caculateAge(patientInfo.getBirthday()));
		patientService.update(patientInfo);
		return new ResultModel();
	}

}
