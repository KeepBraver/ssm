package com.dgut.dao;

import com.dgut.domain.ChPrescription;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IChPrescriptionDao {
	@Select("select * from chprescription")
	public List<ChPrescription> findAllChprescription();

	@Select("select * from chprescription where id = #{id}")
	public ChPrescription findById(String id);

	@Select("select * from chprescription where diagnosisCode = #{diagnosisCode}")
	public List<ChPrescription> findByDiagnosisCode(String diagnosisCode);

	@Select(value = "select * from chprescription where registCode = #{registCode}")
	public List<ChPrescription> findAll(Integer registCode);

	@Insert("insert into chprescription(id,diagnosisCode,drugName,doctorName,specification,unitPrice,doseType,frequence,unit,total,account,date,"
			+ "registCode,direction)values(#{id},#{diagnosisCode},#{drugName},#{doctorName},#{specification},#{unitPrice},#{doseType},#{frequence},#{unit},#{total},"
			+ "#{account},#{date},#{registCode},#{direction})")
	public int insert(ChPrescription chprescription);

	@Update("update chprescription set diagnosisCode=#{diagnosisCode},drugName=#{drugName},specification=#{specification},"
			+ "unitPrice=#{unitPrice},unit=#{unit},total=#{total},account=#{account},date=#{date},registCode=#{registCode} "
			+ "direction = #{direction} ,doseType = #{doseType},frequence = #{frequence} where id=#{id} ")
	public void update(ChPrescription chprescription);

	@Delete("delete from chprescription where id  = #{id}")
	public Integer delete(String id);
}
