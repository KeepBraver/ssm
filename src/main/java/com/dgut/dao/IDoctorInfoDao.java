package com.dgut.dao;

import com.dgut.domain.DoctorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IDoctorInfoDao {

	@Select(value = "select * from doctorinfo")
	List<DoctorInfo> findAll();

	@Select(value = "select doctorId from doctorinfo where department = #{deptName} and doctorName = #{doctorName}")
	Integer findByNameAndDept(@Param("deptName") String deptName, @Param("doctorName") String doctorName);

	@Select(value = "select * from doctorinfo where doctorId = #{doctorId}")
	DoctorInfo findById(Integer doctorId);

	@Select(value = "select * from doctorinfo where name = #{doctorName}")
	DoctorInfo findByDoctorName(String doctorName);

	@Select(value = "select * from doctorinfo where department = #{department}")
	List<DoctorInfo> findBydeptName(String department);

	@Insert("insert into doctorinfo(doctorName,sex,birthday,"
			+ "idNumber,address,phone,department) values(#{doctorName},#{sex},#{birthday},"
			+ "#{idNumber},#{address},#{phone},#{department})")
	public int insert(DoctorInfo doctorInfo);

	@Update("update doctorinfo set doctorName=#{doctorName},sex=#{sex},birthday=#{birthday},"
			+ "idNumber=#{idNumber},address=#{address},phone=#{phone},department=#{department} "
			+ "where doctorId=#{doctorId}")
	public Integer update(DoctorInfo doctorInfo);

	@Delete(value = "delete from doctorinfo where doctorId = #{doctorId}")
	void deleteById(Integer doctorId);

}
