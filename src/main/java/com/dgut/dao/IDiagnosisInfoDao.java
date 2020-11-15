package com.dgut.dao;

import com.dgut.domain.DiagnosisInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDiagnosisInfoDao {

	@Select("select * from diagnosisInfo")
	public List<DiagnosisInfo> findAllDiagnosisInfo();

	@Select("select * from diagnosisInfo where diagnosisCode = #{diagnosisCoded}")
	public DiagnosisInfo findByDiagnosisCode(String diagnosisCode);

	@Select(value = "select * from diagnosisInfo where registCode = #{registCode}")
	public DiagnosisInfo findByRegistCode(Integer registCode);

	@Select("select * from diagnosisInfo where doctorId = #{doctorId}")
	public DiagnosisInfo findByDoctorId(int doctorId);

	@Insert("insert into diagnosisInfo(diagnosisCode,registCode,doctorId,mainsuitInfo,presentIllness,passIllness,allergyIllness,"
			+ "systolic,diastolic,bloodSugar,pulse,weight,symptom,diagnosticInfo,diagnosticDate)"
			+ "values(#{diagnosisCode},#{registCode},#{doctorId},#{mainsuitInfo},#{presentIllness},#{passIllness},#{allergyIllness},"
			+ "#{systolic},#{diastolic},#{bloodSugar},#{pulse},#{weight},#{symptom},#{diagnosticInfo},#{diagnosticDate})")
	public int insertDiagnosisInfo(DiagnosisInfo diagnosisInfo);

	@Update("update diagnosisInfo set mainsuitInfo=#{mainsuitInfo}, doctorId=#{doctorId},presentIllness=#{presentIllness},passIllness=#{passIllness},allergyIllness=#{allergyIllness},"
			+ "systolic=#{systolic},diastolic=#{diastolic},bloodSugar=#{bloodSugar},pulse=#{pulse},weight=#{weight},symptom=#{symptom},"
			+ "diagnosticInfo=#{diagnosticInfo},diagnosticDate=#{diagnosticDate},diagnosticTime=#{diagnosticTime} "
			+ "where diagnosisCode = #{diagnosisCode}")
	public void update(DiagnosisInfo diagnosisInfo);
}
