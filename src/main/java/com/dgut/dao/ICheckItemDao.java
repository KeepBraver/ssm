package com.dgut.dao;

import com.dgut.domain.CheckItem;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ICheckItemDao {

	@Select(value = "select * from checkItem")
	List<CheckItem> findAll();

	@Select(value = "SELECT * FROM checkitem WHERE item LIKE #{item}")
	List<CheckItem> findByItem(String item);

	@Update("update checkitem set item = #{item},unitPrice = #{unitPrice},unit = #{unit},deptName = #{deptName} where id = #{id}")
	Integer update(CheckItem checkItem);

	@Insert("insert into checkitem(item,unit,unitPrice,deptName)values(#{item},#{unit},#{unitPrice},#{deptName})")
	Integer insert(CheckItem checkItem);

}
