package com.dgut.service.impl;

import com.dgut.dao.*;
import com.dgut.domain.ChPrescription;
import com.dgut.domain.FlowSheet;
import com.dgut.domain.InspectionItems;
import com.dgut.domain.WmPrescription;
import com.dgut.service.IFlowSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("flowSheetService")
public class FlowSheetServiceImpl implements IFlowSheetService {

	@Autowired
	private IFlowSheetDao flowSheetDao;

	@Autowired
	private IRegisterInfoDao registerInfoDao;

	@Autowired
	private IWmPrescriptionDao wmPrescriptionDao;

	@Autowired
	private IChPrescriptionDao chPrescriptionDao;

	@Autowired
	private IInspectionItemsDao iInspectionItemsDao;

	@Override
	public Integer insert(FlowSheet flowSheet) {
		return flowSheetDao.insert(flowSheet);
	}

	@Override
	public List<FlowSheet> findByRegistCode(Integer registCode) {
		return flowSheetDao.findByRegistCode(registCode);
	}

	@Override
	public List<Object> charge(Integer registCode) {
		List<String> typeIdList = new ArrayList<>();
		List<FlowSheet> flowSheets = flowSheetDao.findByRegistCode(registCode);
		for (FlowSheet flowSheet : flowSheets) {
			typeIdList.add(flowSheet.getChargeTypeId());
		}
		List<WmPrescription> wmPrescriptionList = wmPrescriptionDao.findByRegistCode(registCode);
		List<ChPrescription> chPrescriptionList = chPrescriptionDao.findAll(registCode);
		List<InspectionItems> inspectionItemsList = iInspectionItemsDao.findByRegistCode(registCode);
		Iterator<WmPrescription> wmPrescriptionIterable = wmPrescriptionList.iterator();
		Iterator<ChPrescription> chPrescriptionListIterator = chPrescriptionList.iterator();
		Iterator<InspectionItems> inspectionItemsListIterator = inspectionItemsList.iterator();

		while (wmPrescriptionIterable.hasNext()) {
			WmPrescription wmPrescription = wmPrescriptionIterable.next();
			if (typeIdList.contains(wmPrescription.getId())) {
				wmPrescriptionIterable.remove();
			}
		}
		while (chPrescriptionListIterator.hasNext()) {
			ChPrescription chPrescription = chPrescriptionListIterator.next();
			if (typeIdList.contains(chPrescription.getId())) {
				chPrescriptionListIterator.remove();
			}
		}
		while (inspectionItemsListIterator.hasNext()) {
			InspectionItems inspectionItems = inspectionItemsListIterator.next();
			if (typeIdList.contains(inspectionItems.getId())) {
				inspectionItemsListIterator.remove();
			}
		}
		List<Object> objectList = new ArrayList<>();
		objectList.add(wmPrescriptionList);
		objectList.add(chPrescriptionList);
		objectList.add(inspectionItemsList);
		return objectList;
	}

	@Override
	public List<FlowSheet> findByRefund(Integer registCode) {
		List<FlowSheet> flowSheet = flowSheetDao.findByChargeTypeId(registCode);
		flowSheet.addAll(flowSheetDao.find(registCode));
		return flowSheet;
	}

	@Override
	public List<Object> findRecordByRegistCode(Integer registCode) {
		List<Object> objectList = new ArrayList<>();
		List<FlowSheet> flowSheetList = flowSheetDao.findByChargeTypeId(registCode);
		flowSheetList.addAll(flowSheetDao.find(registCode));
		for (int i = 0; i < flowSheetList.size(); i++) {
			FlowSheet flowSheet = flowSheetList.get(i);
			System.out.println(flowSheet);
			String chargeTypeId = flowSheet.getChargeTypeId();
			switch (flowSheet.getChType()) {
			case "挂号费用":
				objectList.add(registerInfoDao.findByRegistCode(registCode));
				break;
			case "西药费用":
				objectList.add(wmPrescriptionDao.findById(chargeTypeId));
				break;
			case "中药费用":
				objectList.add(chPrescriptionDao.findById(chargeTypeId));
				break;
			case "诊断费用":
				objectList.add(iInspectionItemsDao.findById(chargeTypeId));
				break;
			default:
				System.out.println("有错误");
				break;
			}
		}
		return objectList;
	}

	@Override
	public List<FlowSheet> findAll() {
		return flowSheetDao.findAll();
	}

}
