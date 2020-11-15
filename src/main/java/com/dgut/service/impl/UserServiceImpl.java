package com.dgut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgut.dao.IUserDao;
import com.dgut.domain.User;
import com.dgut.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.findByNameAndPassword(user);
	}

}
