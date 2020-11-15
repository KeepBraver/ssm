package com.dgut.controller;

import com.dgut.domain.RegisterInfo;
import com.dgut.model.ResultModel;
import com.dgut.service.IRegisterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("register")
@ResponseBody
public class RegisterController {

	@Autowired
	private IRegisterService registerService;

	@GetMapping("list")
	public ResultModel findAll(@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer limit,
			@RequestParam(required = false, defaultValue = "all") String date,
			@RequestParam(required = false, defaultValue = "") String patientName) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(registerService.findAll(date, patientName));
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("findByRegistCode")
	public ResultModel findByRegistCode(Integer registCode) {
		RegisterInfo registerInfo = registerService.findByRegistCode(registCode);
		if (registerInfo == null)
			return new ResultModel("无数据");
		else
			return new ResultModel(registerInfo);
	}

	@GetMapping("listByDoctor")
	public ResultModel findByDoctor(@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer limit, String doctorName, String deptName) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(registerService.findByDoctor(doctorName, deptName));
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("listByDoctorRecord")
	public ResultModel findByDoctorRecord(@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer limit, String doctorName, @RequestParam("deptName")String deptName) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(registerService.findByDoctorRecord(doctorName, deptName));
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}
	@GetMapping("consultation")
	public Object consultation(String doctorName, String deptName) {
		return registerService.findConsultation(doctorName, deptName);
	}

	@GetMapping("findMaxRegistCode")
	public ResultModel findMaxRegistCode() {
		return new ResultModel(registerService.findByRegistCode());
	}

	@PostMapping("update")
	public ResultModel update(RegisterInfo registerInfo) {
		Integer i;
		registerInfo.setDate(new Date());
		if (registerInfo.getRegistCode() == null || registerInfo.getRegistCode() == 0) {
			registerInfo.setRegisterStatus("未就诊");
			i = registerService.insertRegisterInfo(registerInfo);
		}
		i = registerService.update(registerInfo);
		return i == 0 ? new ResultModel("保存失败") : new ResultModel("保存成功");
	}

	@PostMapping("changeStatus")
	public void changeStatus(Integer registCode, String status) {
		if (status.equals("就诊中")) {
			registerService.updateStatusIng(registCode);
		} else {
			registerService.updateStatusEnd(registCode);
		}
	}

	@PostMapping("delete")
	public ResultModel delete(Integer registCode) {
		registerService.delete(registCode);
		return new ResultModel();
	}

}
