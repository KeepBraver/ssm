package com.dgut.dao;

import com.dgut.domain.FlowSheet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IFlowSheetDao {

	@Select("select * from flowsheet")
	public List<FlowSheet> findAll();

	@Select("select * from flowsheet where id = #{id}")
	public FlowSheet findByOpId(String id);

	@Select("select * from flowsheet where caseNum = #{caseNum}")
	public List<FlowSheet> findByCaseNum(String caseNum);

	@Select("select * from flowsheet where registCode = #{registCode}")
	public List<FlowSheet> findByRegistCode(Integer registCode);

	@Select("SELECT * from (SELECT * ,count('chargeTypeId') as count_times\n" + "FROM flowsheet\n"
			+ "GROUP BY chargeTypeId  \n" + "HAVING count_times = 1)  as a WHERE a.registCode = #{registCode} ")
	public List<FlowSheet> findByChargeTypeId(Integer registCode);
	
	@Select("SELECT *,COUNT(a.chType) as counts_times FROM (SELECT flowsheet.* from flowsheet, "
			+ "registerinfo WHERE registerinfo.registerStatus='未就诊' and flowsheet.registCode = registerinfo.registCode "
			+ "and flowsheet.registCode = #{registCode} and chargeTypeId is null ) as a GROUP BY chType HAVING counts_times = 1")
	public List<FlowSheet> find(Integer registCode);

	@Insert("insert into flowsheet(id,retreat,account,caseNum,chType,date,operator,registCode,chargeTypeId)"
			+ "values(#{id},#{retreat},#{account},#{caseNum},#{chType},#{date},#{operator},#{registCode},#{chargeTypeId})")
	public int insert(FlowSheet flowSheet);

	@Update("update flowsheet set retreat=#{retreat},account=#{account},caseNum=#{caseNum},"
			+ "chCode=#{chCode},chType=#{chType},operator=#{operator},date=#{date},chargeTypeId = #{chargeTypeId} "
			+ "where id=#{id}")
	public void update(FlowSheet flowSheet);
}
