package com.dgut.dao;

import com.dgut.domain.DrugInfo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IDrugInfoDao {

	@Select("select * from druginfo")
	public List<DrugInfo> findAll();

	@Select("select * from druginfo where drugCode=#{drugCode}")
	public DrugInfo findByDrugCode(String drugCode);

	@Select("select * from druginfo where drugName=#{drugName}")
	public DrugInfo findByDrugName(String drugName);

	@Select(value = "select * from druginfo where drugName like #{drugName}")
	public List<DrugInfo> findLikeDrugName(String drugName);

	@Insert("insert into druginfo(drugCode,drugName,specification,doseType,manufacturer,unit,unitPrice,markingNum,isMedicare,drugType)"
			+ "values(#{drugCode},#{drugName},#{specification},#{doseType},#{manufacturer},#{unit},#{unitPrice},"
			+ "#{markingNum},#{isMedicare},#{drugType})")
	public int insert(DrugInfo drugInfo);

	@Update("update druginfo set drugName=#{drugName},specification=#{specification},doseType=#{doseType},"
			+ "manufacturer=#{manufacturer},unit=#{unit},unitPrice=#{unitPrice},"
			+ "markingNum=#{markingNum}, isMedicare=#{isMedicare},drugType=#{drugType}" + "where drugCode=#{drugCode}")
	public Integer update(DrugInfo drugInfo);

	@Delete("delete * from id = #{id}")
	Integer delete(String id);
}
