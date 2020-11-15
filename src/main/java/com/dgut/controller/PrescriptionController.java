package com.dgut.controller;

import com.dgut.domain.ChPrescription;
import com.dgut.domain.WmPrescription;
import com.dgut.model.ResultModel;
import com.dgut.service.IChPrescriptionService;
import com.dgut.service.IWmPrescriptionService;
import com.dgut.utils.MajorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("prescript")
public class PrescriptionController {

	@Autowired
	private IChPrescriptionService chPrescriptionService;

	@Autowired
	private IWmPrescriptionService wmPrescriptionService;

	@PostMapping("addWm")
	public ResultModel add(WmPrescription wmPrescription) {
		wmPrescription.setAccount(wmPrescription.getUnitPrice() * wmPrescription.getTotal());
		wmPrescription.setId(MajorKey.createPK());
		wmPrescription.setDate(new Date());
		return new ResultModel(wmPrescriptionService.insert(wmPrescription));
	}

	@PostMapping("addCh")
	public ResultModel add(ChPrescription chPrescription) {
		chPrescription.setAccount(chPrescription.getUnitPrice() * chPrescription.getTotal());
		chPrescription.setDate(new Date());
		chPrescription.setId(MajorKey.createPK());
		return new ResultModel(chPrescriptionService.insert(chPrescription));
	}

	@GetMapping("findAllByRegistCode")
	public ResultModel findAll(Integer registCode) {
		List<Object> objectList = new ArrayList<>();
		objectList.addAll(chPrescriptionService.findAll(registCode));
		objectList.addAll(wmPrescriptionService.findAll(registCode));
		return new ResultModel(objectList);
	}

	@PostMapping("delete")
	public ResultModel delete(String id) {
		chPrescriptionService.delete(id);
		wmPrescriptionService.delete(id);
		return new ResultModel();
	}
}
