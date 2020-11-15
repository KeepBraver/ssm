package com.dgut.dao;

import com.dgut.domain.PatientInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IPatientInfoDao {

	@Select("select * from patientinfo")
	public List<PatientInfo> findAllPatients();

	@Select("select * from patientinfo where patientid = #{id}")
	public PatientInfo findById(int id);

	@Select("select * from patientinfo where idNumber = #{idNumber}")
	public PatientInfo findByIdNumber(@Param(value = "idNumber") String idNumber);

	@Select("select * from patientinfo where name = #{name}")
	public List<PatientInfo> findByName(String name);

	@Insert("insert into patientinfo(idNumber,name,sex,age,birthday,phone,caseNum) "
			+ "values (#{idNumber},#{name},#{sex},#{age},#{birthday},#{phone},#{caseNum})")
	public int insert(PatientInfo patient);

	@Update("update patientinfo set idNumber=#{idNumber},name=#{name},sex=#{sex},age=#{age},birthday=#{birthday},phone=#{phone},caseNum=#{caseNum}"
			+ " where patientId =#{patientId}")
	public void update(PatientInfo patient);
}
