package com.dgut.controller;

import com.dgut.domain.InspectionItems;
import com.dgut.model.ResultModel;
import com.dgut.service.IInspectionItemsService;
import com.dgut.utils.MajorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("inspectionitems")
@ResponseBody
public class InspectionItemsController {

	@Autowired
	private IInspectionItemsService inspectionItemsService;

	@PostMapping("add")
	public Object add(InspectionItems inspectionItems) {
		inspectionItems.setAccount(inspectionItems.getTotal() * inspectionItems.getUnitPrice());
		inspectionItems.setDate(new Date());
		inspectionItems.setId(MajorKey.createPK());
		return inspectionItemsService.insertInspectionItems(inspectionItems);
	}

	@GetMapping("list")
	public ResultModel findAll(Integer registCode) {
		return new ResultModel(inspectionItemsService.findAll(registCode));
	}

	@PostMapping("delete")
	public Object delete(String id) {
		return inspectionItemsService.deleteById(id);
	}
}
