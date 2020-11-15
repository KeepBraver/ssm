package com.dgut.dao;

import com.dgut.domain.DrugEntryOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDrugEntryOrderDao {

	@Select("select * from drugentryorder")
	public List<DrugEntryOrder> findAll();

	@Select("select * from drugentryorder")
	@Results(value = { @Result(property = "drugCode", column = "drugCode"),
			@Result(property = "drugInfo", one = @One(select = "com.dgut.dao.IDrugInfoDao.findByDrugCode"), column = "drugCode") })
	public List<DrugEntryOrder> findAllwithDrugInfo();

	@Select("select * from drugentryorder where id = #{id}")
	public DrugEntryOrder findById(String id);

	@Select("select * from drugentryorder where entryLibraryId = #{entryLibraryId}")
	@Results(value = { @Result(property = "drugCode", column = "drugCode"),
			@Result(property = "drugInfo", one = @One(select = "com.dgut.dao.IDrugInfoDao.findByDrugCode"), column = "drugCode") })
	public List<DrugEntryOrder> findByEntryLibraryId(Integer entryLibraryId);

	@Select("select * from drugentryorder where drugCode = #{drugCode}")
	public List<DrugEntryOrder> findByDrugCode(String drugCode);

	@Insert("insert into drugentryorder(id,entryLibraryId,drugCode,entryNum) values(#{id},#{entryLibraryId},#{drugCode},#{entryNum})")
	public int insert(DrugEntryOrder drugEntryOrder);

	@Update("update drugentryorder set entryLibraryId=#{entryLibraryId},drugCode=#{drugCode},entryNum=#{entryNum} where id = #{id}")
	public void update(DrugEntryOrder drugEntryOrder);

	@Delete("delete from drugentryorder where id = #{id}")
	Integer delete(String id);
}
