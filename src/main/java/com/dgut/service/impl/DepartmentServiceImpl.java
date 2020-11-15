package com.dgut.service.impl;

import com.dgut.dao.IDepartmentDao;
import com.dgut.domain.Department;
import com.dgut.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentDao departmentDao;

	@Override
	public List<Department> findAll() {
		return departmentDao.findAlldepartmentwithWorkers();
	}

	@Override
	public Integer update(Department department) {
		return departmentDao.updatedepartment(department);
	}

	@Override
	public Integer insert(Department department) {
		return departmentDao.insertdepartment(department);
	}
}
