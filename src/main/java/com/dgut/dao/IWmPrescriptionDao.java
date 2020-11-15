package com.dgut.dao;

import com.dgut.domain.WmPrescription;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IWmPrescriptionDao {

    @Select("select * from wmprescription")
    public List<WmPrescription> findAllWmprescription();

    @Select("select * from wmprescription where id = #{id}")
    public WmPrescription findById(String id);

    @Select("select * from wmprescription where diagnosisCode = #{diagnosisCode}")
    public List<WmPrescription> findByDiagnosisCode(String diagnosisCode);

    @Select("select * from wmprescription where registCode = #{registCode}")
    public List<WmPrescription> findByRegistCode(Integer registCode);

    @Insert("insert into wmprescription(id,diagnosisCode,drugName,specification," +
            "unitPrice,doseType,unit,direction,frequence,total,account,date,doctorName,registCode)" +
            "values(#{id},#{diagnosisCode},#{drugName},#{specification}," +
            "#{unitPrice},#{doseType},#{unit},#{direction},#{frequence},#{total},#{account},#{date},#{doctorName},#{registCode})")
    public int insert(WmPrescription wmprescription);

    @Update("update wmprescription set diagnosisCode=#{diagnosisCode},drugName=#{drugName},specification=#{specification}," +
            "unitPrice=#{unitPrice},doseType=#{doseType},unit=#{unit},direction=#{direction},frequence=#{frequence},total=#{total}," +
            "account=#{account},date=#{date},doctorName=#{doctorName},registCode=#{registCode}" +
            "where id=#{id} ")
    public void update(WmPrescription wmprescription);

    @Delete("delete from wmprescription where id  = #{id}")
    public Integer delete(String id);
}