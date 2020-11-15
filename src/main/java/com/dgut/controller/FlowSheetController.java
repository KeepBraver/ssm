package com.dgut.controller;

import com.dgut.domain.FlowSheet;
import com.dgut.model.ResultModel;
import com.dgut.service.IChPrescriptionService;
import com.dgut.service.IFlowSheetService;
import com.dgut.service.IRegisterService;
import com.dgut.service.IWmPrescriptionService;
import com.dgut.utils.MajorKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("flowSheet")
@ResponseBody
public class FlowSheetController {

	@Autowired
	private IFlowSheetService flowSheetService;

	@Autowired
	private IRegisterService registerService;
	
	@Autowired
	private IWmPrescriptionService wmPrescriptionService;
	
	@Autowired
	private IChPrescriptionService chPrescriptionService;
	
	@GetMapping("list")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(flowSheetService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("add")
	public ResultModel add(FlowSheet flowSheet) {
		flowSheet.setId(MajorKey.createPK());
		flowSheet.setDate(new Date());
		String msg = flowSheetService.insert(flowSheet) == 0 ? "保存失败" : "保存成功";
		return new ResultModel(msg);
	}

	@PostMapping("addFlowSheet")
	public ResultModel addFlowSheet(FlowSheet flowSheet) {
		flowSheet.setDate(new Date());
		flowSheet.setRetreat("收费");
		flowSheet.setId(MajorKey.createPK());
		if(flowSheet.getChType().equals("西药费用")) {
			wmPrescriptionService.updateAccount(flowSheet);
		}else if(flowSheet.getChType().equals("中药费用")) {
			chPrescriptionService.updateAccount(flowSheet);
		}
		flowSheetService.insert(flowSheet);
		return new ResultModel();
	}

	@GetMapping("refundByRegistCode")
	public Object findByRegistCode(Integer registCode) {
		List<Object> objects = new ArrayList<>();
		objects.add(flowSheetService.findByRefund(registCode));
		objects.add(flowSheetService.findRecordByRegistCode(registCode));
		return objects;
	}

	@GetMapping("charge")
	public Object charge(Integer registCode) {
		return flowSheetService.charge(registCode);
	}

	@PostMapping("refund")
	public Object refund(FlowSheet flowSheet) {
		flowSheet.setDate(new Date());
		flowSheet.setId(MajorKey.createPK());
		flowSheet.setRetreat("退款");
		if (flowSheet.getChType().equals("挂号费用")) {
			registerService.delete(flowSheet.getRegistCode());
		}else if(flowSheet.getChType().equals("西药费用")) {
			wmPrescriptionService.updateAccount(flowSheet);
		}else if(flowSheet.getChType().equals("中药费用")) {
			chPrescriptionService.updateAccount(flowSheet);
		}
		flowSheetService.insert(flowSheet);
		return new ResultModel();
	}
}
