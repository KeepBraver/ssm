package com.dgut.dao;

import com.dgut.domain.EntryLibrary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IEntryLibraryDao {

	@Select("select * from entrylibrary")
	public List<EntryLibrary> findAll();

	@Select("select * from entrylibrary")
	@Results(value = { @Result(property = "id", column = "id", id = true),
			@Result(property = "drugEntryOrders", many = @Many(select = "com.dgut.dao.IDrugEntryOrderDao.findByEntryLibraryId"), column = "id") })
	public List<EntryLibrary> findAllwithDrugdetail();

	@Select("select * from entrylibrary where id = #{id}")
	public EntryLibrary findById(Integer id);

	@Select("select * from entrylibrary where drugName like #{drugName}")
	List<EntryLibrary> findByName(String drugName);

	@Select("select * from entrylibrary where id = (select max(id) as id from entrylibrary) and status = 0")
	EntryLibrary findMax();

	@Insert("insert into entrylibrary(invoiceCode,supplyCompany,invoiceDate,entryDate,operator)"
			+ "values(#{invoiceCode},#{supplyCompany},#{invoiceDate},#{entryDate},#{operator})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(EntryLibrary entryLibrary);

	@Update("update entrylibrary set invoiceCode=#{invoiceCode},supplyCompany=#{supplyCompany},invoiceDate=#{invoiceDate},"
			+ "entryDate=#{entryDate},operator=#{operator} " + "where id=#{id}")
	public void update(EntryLibrary entryLibrary);

	@Update("update entrylibrary set status = 1 where id = #{id}")
	Integer updateStatus(Integer id);

}
