package com.dgut.domain;

public class CheckItem {
	private Integer id;
	private String item;
	private String deptName;
	private String unit;
	private String unitPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "CheckItem{" + "id=" + id + ", item='" + item + '\'' + ", deptName='" + deptName + '\'' + ", unit='"
				+ unit + '\'' + ", unitPrice='" + unitPrice + '\'' + '}';
	}
}
