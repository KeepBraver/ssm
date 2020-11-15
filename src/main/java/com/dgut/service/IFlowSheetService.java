package com.dgut.service;

import com.dgut.domain.FlowSheet;

import java.util.List;

public interface IFlowSheetService {
	Integer insert(FlowSheet flowSheet);

	List<Object> findRecordByRegistCode(Integer registCode);

	List<FlowSheet> findByRegistCode(Integer registCode);

	List<Object> charge(Integer registCode);

	List<FlowSheet> findByRefund(Integer registCode);

	List<FlowSheet> findAll();
}
