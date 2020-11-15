package com.dgut.controller;

import com.dgut.domain.CheckItem;
import com.dgut.model.ResultModel;
import com.dgut.service.ICheckItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("checkItem")
@ResponseBody
public class CheckItemController {

	@Autowired
	private ICheckItemService checkItemService;

	@GetMapping("findByItem")
	public ResultModel findByItem(String item) {
		return new ResultModel(checkItemService.findByItem(item));
	}

	@GetMapping("list")
	public ResultModel findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(checkItemService.findAll());
		return new ResultModel(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("update")
	public ResultModel update(CheckItem checkItem) {
		checkItemService.update(checkItem);
		return new ResultModel();
	}
}
