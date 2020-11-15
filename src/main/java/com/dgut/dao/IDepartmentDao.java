package com.dgut.dao;

import com.dgut.domain.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IDepartmentDao {

	@Select("select * from department")
	public List<Department> findAlldepartment();

	@Select("select * from department")
	@Results(value = { @Result(property = "deptId", column = "deptId", id = true),
			@Result(property = "deptName", column = "deptName"),
			@Result(property = "doctors", many = @Many(select = "com.dgut.dao.IDoctorInfoDao.findBydeptName", fetchType = FetchType.EAGER), column = "deptName") })
	public List<Department> findAlldepartmentwithWorkers();

	@Select("select * from department where deptId = #{id}")
	public Department findById(int id);

	@Select("select * from department where deptId = #{id}")
	@Results(value = { @Result(property = "deptId", column = "deptId", id = true),
			@Result(property = "deptName", column = "deptName"),
			@Result(property = "doctors", many = @Many(select = "com.dgut.dao.IDoctorInfoDao.findBydeptName", fetchType = FetchType.LAZY), column = "deptName") })
	public Department findByIdwithWorkers(int id);

	@Select("select * from department where deptName = #{deptName}")
	public Department findByName(String deptName);

	@Insert("insert into department(deptName,deptIntroduct,diagnosticRange,deptLeader,telephone) values (#{deptName},#{deptIntroduct},"
			+ "#{diagnosticRange},#{deptLeader},#{telephone})")
	public int insertdepartment(Department department);

	@Update("update department set deptName = #{deptName} ,deptIntroduct = #{deptIntroduct},diagnosticRange = #{diagnosticRange},"
			+ "deptLeader = #{deptLeader} ,telephone = #{telephone} where deptId = #{deptId}")
	public Integer updatedepartment(Department department);
}
