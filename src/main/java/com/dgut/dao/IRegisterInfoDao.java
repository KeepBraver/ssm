package com.dgut.dao;

import com.dgut.domain.RegisterInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRegisterInfoDao {

	@Select(value = { "<script>", "select * from registerinfo where date = date(now())",
			"<when test='patientName!=null' >", " AND patientName = #{patientName}", "</when>", "</script>" })
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById", fetchType = FetchType.EAGER), column = "patientId"), })
	List<RegisterInfo> findAllToday(@Param("patientName") String patientName);

	@Select(value = { "<script>",
			"select * from registerinfo where YEARWEEK(date_format(date,'%Y-%m-%d')) = YEARWEEK(now())",
			"<when test='patientName!=null' >", " AND patientName = #{patientName}", "</when>", "</script>" })
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById", fetchType = FetchType.EAGER), column = "patientId"), })
	List<RegisterInfo> findAllWeek(String patientName);

	@Select(value = { "<script>",
			"select * from registerinfo where DATE_FORMAT(date, '%Y%m') = DATE_FORMAT(CURDATE(),'%Y%m')",
			"<when test='patientName!=null' >", " AND patientName = #{patientName}", "</when>", "</script>" })
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById", fetchType = FetchType.EAGER), column = "patientId"), })
	List<RegisterInfo> findAllMonth(String patientName);

	@Select(value = { "<script>", "select * from registerinfo where 1=1", "<when test='patientName!=null' >",
			" AND patientName = #{patientName}", "</when>", "</script>" })
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById", fetchType = FetchType.EAGER), column = "patientId"), })
	List<RegisterInfo> findAll(String patientName);

	@Select(value = "select * from registerinfo where deptName = #{deptName} and doctorName = #{doctorName} and registerStatus = '就诊中' limit 1 ")
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById"), column = "patientId"), })
	RegisterInfo findConsultation(@Param("doctorName") String doctorName, @Param("deptName") String deptName);

	@Select(value = "select * from registerinfo where registCode = #{registCode}")
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById", fetchType = FetchType.EAGER), column = "patientId"), })
	public RegisterInfo findByRegistCode(Integer registCode);

	@Select(value = "select * from registerinfo where deptName = #{deptName} and doctorName = #{doctorName} and registerStatus = '未就诊' ")
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById"), column = "patientId"), })
	public List<RegisterInfo> findByDoctor(@Param(value = "doctorName") String doctorName,
			@Param(value = "deptName") String deptName);

	@Select(value = "select max(registCode) from registerinfo")
	public Integer maxRegistCode();

	@Insert(value = "insert into registerinfo(registCode,patientName,fsDiagnosis,registType,costType,"
			+ "deptName,doctorName,date,regCost,operator,registerStatus,patientId) values(#{registCode},"
			+ "#{patientName},#{fsDiagnosis},#{registType},#{costType},#{deptName},#{doctorName},#{date},#{regCost},"
			+ "#{operator},#{registerStatus},#{patientId})")
	public Integer insertRegisterInfo(RegisterInfo registerInfo);

	@Update(value = "update registerinfo set patientName = #{patientName},"
			+ "fsDiagnosis = #{fsDiagnosis},registType = #{registType},costType = #{costType},deptName = #{deptName},doctorName = #{doctorName},"
			+ "regCost = #{regCost},operator = #{operator},registerStatus = #{registerStatus} ,date = #{date}, patientId=#{patientId} where registCode = #{registCode}")
	public Integer updateRegisterInfo(RegisterInfo registerInfo);

	@Update(value = "update registerinfo set registerStatus  = '就诊中'  where registCode = #{registCode}")
	public Integer updateStatusIng(Integer registCode);

	@Update(value = "update registerinfo set registerStatus  = '就诊完'   where registCode = #{registCode}")
	public Integer updateStatusEnd(Integer registCode);

	@Delete(value = "delete from registerinfo where registCode = #{registCode}")
	public Integer deleteByRegistCode(Integer registCode);
	
	@Select(value = "select * from registerinfo where deptName = #{deptName} and doctorName = #{doctorName} and registerStatus = '就诊完' ")
	@Results(value = {
			@Result(property = "patientInfo", one = @One(select = "com.dgut.dao.IPatientInfoDao.findById"), column = "patientId"), })
	List<RegisterInfo> findByDoctorRecord(@Param("doctorName")String doctorName, @Param("deptName")String deptName);

}
