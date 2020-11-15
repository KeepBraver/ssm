package com.dgut.service;

import com.dgut.domain.Department;

import java.util.List;

public interface IDepartmentService {

	List<Department> findAll();

	Integer update(Department department);

	Integer insert(Department department);
}
