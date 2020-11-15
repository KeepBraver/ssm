package com.dgut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgut.domain.User;
import com.dgut.model.ResultModel;
import com.dgut.service.IUserService;

@Controller
@RequestMapping("user")
@ResponseBody
public class LoginController {

	@Autowired
	private IUserService userService;

	@PostMapping("login")
	public ResultModel login(User user) {
		user = userService.login(user);
		if (user == null) {
			return new ResultModel("用户名或密码错误");
		} else {
			return new ResultModel(user);
		}
	}

}
