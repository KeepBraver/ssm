package com.dgut.controller;

import com.dgut.domain.CheckItem;
import com.dgut.domain.DrugInfo;
import com.dgut.model.ResultModel;
import com.dgut.service.IDrugInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("drugInfo")
@ResponseBody
public class DrugInfoController {
	@Autowired
	private IDrugInfoService drugInfoService;

	@GetMapping("findByName")
	public Object findByName(String name) {
		return drugInfoService.findLikeDrugName(name);
	}

	@GetMapping("list")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(drugInfoService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("delete")
	public Object delete(String id) {
		return drugInfoService.delete(id);
	}

	@PostMapping("update")
	public ResultModel update(DrugInfo drugInfo) {
		drugInfoService.update(drugInfo);
		return new ResultModel();
	}
}
