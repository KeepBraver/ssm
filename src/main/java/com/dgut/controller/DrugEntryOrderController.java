package com.dgut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgut.domain.DrugEntryOrder;
import com.dgut.model.ResultModel;
import com.dgut.service.IDrugEntryOrderService;
import com.dgut.utils.MajorKey;

@Controller
@RequestMapping("entryOrder")
@ResponseBody
public class DrugEntryOrderController {

	@Autowired
	private IDrugEntryOrderService drugEntryOrderService;

	@PostMapping("insert")
	public ResultModel insert(DrugEntryOrder drugEntryOrder) {
		drugEntryOrder.setId(MajorKey.createPK());
		drugEntryOrderService.insert(drugEntryOrder);
		return new ResultModel();
	}

	@GetMapping("listById")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit, Integer entryLibraryId) {

		return new ResultModel(drugEntryOrderService.findByEntryLibraryId(entryLibraryId));

	}

	
	@PostMapping("delete")
	public Object delete(String id) {
		return drugEntryOrderService.delete(id);
	}

}
