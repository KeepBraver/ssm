package com.dgut.service;

import com.dgut.domain.CheckItem;

import java.util.List;

public interface ICheckItemService {

	List<CheckItem> findAll();

	List<CheckItem> findByItem(String item);

	Integer update(CheckItem checkItem);
}
