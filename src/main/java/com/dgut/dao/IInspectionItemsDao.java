package com.dgut.dao;

import com.dgut.domain.InspectionItems;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IInspectionItemsDao {

	@Select("select * from inspectionitems")
	public List<InspectionItems> findALL();

	@Select("select * from inspectionitems where id = #{id}")
	public InspectionItems findById(String id);

	@Insert("insert into inspectionitems(id,item,deptName,unitPrice,"
			+ "unit,total,account,doctorAdvice,date,registCode) "
			+ "values(#{id},#{item},#{deptName},#{unitPrice},#{unit},#{total},"
			+ "#{account},#{doctorAdvice},#{date},#{registCode})")
	public int insertInspectionItems(InspectionItems inspectionItems);

	@Update("update inspectionitems set item=#{item},"
			+ "deptName=#{deptName},unitPrice=#{unitPrice},unit=#{unit},total=#{total},account=#{account},"
			+ "doctorAdvice=#{doctorAdvice},date=#{date},registCode=#{registCode} where id=#{id}")
	public void updateInspectionItems(InspectionItems inspectionItems);

	@Select("select * from inspectionitems where registCode = #{registCode}")
	List<InspectionItems> findByRegistCode(Integer registCode);

	@Delete(value = "delete from inspectionitems where id = #{id}")
	Integer deleteById(String id);
}
