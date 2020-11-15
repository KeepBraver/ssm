package com.dgut.controller;

import com.dgut.domain.Department;
import com.dgut.model.ResultModel;
import com.dgut.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("department")
@ResponseBody
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping("list")
	public ResultModel findAll() {
		return new ResultModel(departmentService.findAll());
	}

	@PostMapping("update")
	public ResultModel update(Department department) {
		if (department.getDeptId() == 0)
			return new ResultModel(departmentService.insert(department));
		else
			return new ResultModel(departmentService.update(department));
	}
}
