package com.dgut.domain;

import java.io.Serializable;

public class DrugInfo implements Serializable {
	
	private String drugCode;
	private String drugName;
	private String specification;
	private String doseType;
	private String manufacturer;
	private String unit;
	private float unitPrice;
	private String markingNum;
	private String isMedicare;
	private String drugType;

	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getDoseType() {
		return doseType;
	}

	public void setDoseType(String doseType) {
		this.doseType = doseType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMarkingNum() {
		return markingNum;
	}

	public void setMarkingNum(String markingNum) {
		this.markingNum = markingNum;
	}

	public String getIsMedicare() {
		return isMedicare;
	}

	public void setIsMedicare(String isMedicare) {
		this.isMedicare = isMedicare;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	@Override
	public String toString() {
		return "DrugInfo{" + "drugCode='" + drugCode + '\'' + ", drugName='" + drugName + '\'' + ", specification='"
				+ specification + '\'' + ", doseType='" + doseType + '\'' + ", manufacturer='" + manufacturer + '\''
				+ ", unit='" + unit + '\'' + ", unitPrice=" + unitPrice + ", markingNum='" + markingNum + '\''
				+ ", isMedicare='" + isMedicare + '\'' + ", drugType='" + drugType + '\'' + '}';
	}
}
