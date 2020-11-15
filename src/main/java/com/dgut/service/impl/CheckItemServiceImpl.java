package com.dgut.service.impl;

import com.dgut.dao.ICheckItemDao;
import com.dgut.domain.CheckItem;
import com.dgut.service.ICheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("checkItemService")
public class CheckItemServiceImpl implements ICheckItemService {

	@Autowired
	private ICheckItemDao checkItemDao;

	@Override
	public List<CheckItem> findAll() {
		return checkItemDao.findAll();
	}

	@Override
	public List<CheckItem> findByItem(String item) {
		return checkItemDao.findByItem("%" + item + "%");
	}

	@Override
	public Integer update(CheckItem checkItem) {
		int result;
		if (checkItem.getId() != null && checkItem.getId() != 0)
			result = checkItemDao.update(checkItem);
		else
			result = checkItemDao.insert(checkItem);
		return null;
	}
}
