package com.dgut.dao;

import com.dgut.domain.DrugLibrary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDrugLibraryDao {

	@Select("select * from druglibrary")
	public List<DrugLibrary> findAll();

	@Select("select * from druglibrary")
	@Results(value = { @Result(property = "drugCode", column = "drugCode"),
			@Result(property = "drugInfo", one = @One(select = "com.dgut.dao.IDrugInfoDao.findByDrugCode"), column = "drugCode") })
	public List<DrugLibrary> findAllwithDrugInfo();

	@Select("select * from druglibrary where drugCode=#{drugCode}")
	public DrugLibrary findById(String drugCode);

	@Select("select * from druglibrary where drugName=#{drugName}")
	public DrugLibrary findByName(String drugName);

	@Insert("insert into druglibrary(drugCode,drugName,batchNum,validityDate,unit,libraryNum,unitPrice,operator,drugLibraryType) "
			+ "values(#{drugCode},#{drugName},#{batchNum},#{validityDate},#{unit},#{libraryNum},#{unitPrice},#{operator},#{drugLibraryType})")
	public int insert(DrugLibrary drugLibrary);

	@Update("update druglibrary set drugName=#{drugName},batchNum=#{batchNum},validityDate=#{validityDate},unit=#{unit},libraryNum=#{libraryNum},"
			+ "unitPrice=#{unitPrice},operator=#{operator},drugLibraryType=#{drugLibraryType} "
			+ "where drugCode=#{drugCode}")
	public void update(DrugLibrary drugLibrary);

	@Update("update druglibrary set libraryNum = libraryNum +#{num} where drugCode = #{drugCode}")
	Integer updateLibraryNum(@Param("drugCode") String drugCode, @Param("num") Integer num);
	
	@Update("update druglibrary set libraryNum = libraryNum - #{num} where drugName = #{drugName}")
	Integer charge(@Param("drugName") String drugName, @Param("num") Integer num);
	
	@Update("update druglibrary set libraryNum = libraryNum + #{num} where drugName = #{drugName}")
	Integer refund(@Param("drugName") String drugName, @Param("num") Integer num);

}
