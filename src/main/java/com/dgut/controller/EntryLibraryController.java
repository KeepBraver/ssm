package com.dgut.controller;

import com.dgut.domain.EntryLibrary;
import com.dgut.model.ResultModel;
import com.dgut.service.IEntryLibraryService;
import com.dgut.utils.MajorKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("entry")
@ResponseBody
public class EntryLibraryController {

	@Autowired
	private IEntryLibraryService entryLibraryService;

	@GetMapping("findAll")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(entryLibraryService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("insert")
	public ResultModel insert(EntryLibrary entryLibrary) {
		ResultModel rm = new ResultModel();
		entryLibraryService.insert(entryLibrary);
		rm.setData(entryLibrary.getId());
		return rm;
	}

	@GetMapping("findByName")
	public ResultModel findByName(String drugName) {
		List<EntryLibrary> entryLibraryList = entryLibraryService.findByName(drugName);
		return new ResultModel(entryLibraryList);
	}

	@GetMapping("findMax")
	public Object findMax() {
		EntryLibrary entryLibrary = entryLibraryService.findMax();
		if (entryLibrary == null)
			return new ResultModel("无数据");
		else
			return new ResultModel(entryLibrary);

	}

	@PostMapping("updateStatus")
	public Object updateStatus(Integer id) {
		return entryLibraryService.updateStatus(id);
	}
}
