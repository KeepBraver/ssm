package com.dgut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgut.domain.DrugLibrary;
import com.dgut.model.ResultModel;
import com.dgut.service.IDrugLibraryService;
import com.dgut.utils.MajorKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("library")
@ResponseBody
public class DrugLibraryController {
	
	@Autowired
	private IDrugLibraryService drugLibraryService;
	
	@GetMapping("list")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(drugLibraryService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}
	
	@PostMapping("add")
	public Object add(DrugLibrary drugLibrary) {
		
		drugLibrary.setDrugCode(MajorKey.createPK());
		drugLibrary.setLibraryNum(0);
		return drugLibraryService.add(drugLibrary);	
	}

}
