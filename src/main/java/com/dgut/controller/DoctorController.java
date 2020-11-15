package com.dgut.controller;

import com.dgut.domain.DoctorInfo;
import com.dgut.model.ResultModel;
import com.dgut.service.IDoctorInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("doctor")
@ResponseBody
public class DoctorController {

	@Autowired
	IDoctorInfoService doctorInfoService;

	@GetMapping("findByDeptAndName")
	public Integer findByDeptAndName(String deptName, String doctorName) {
		return doctorInfoService.findByNameAndDept(deptName, doctorName);
	}

	@GetMapping("findById")
	public Object findById(Integer doctorId) {
		return doctorInfoService.findById(doctorId);
	}

	@GetMapping("findAll")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(doctorInfoService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("update")
	public Object update(DoctorInfo doctorInfo) {
		doctorInfoService.update(doctorInfo);
		return new ResultModel();
	}

}
