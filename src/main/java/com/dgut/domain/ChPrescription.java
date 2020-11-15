package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ChPrescription {
	private String id;
	private String diagnosisCode;
	private String drugName;
	private float unitPrice;
	private String unit;
	private int total;
	private String frequence;
	private String doseType;
	private float account;
	private String doctorName;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;//
	private String specification;
	private int registCode;
	private String direction;

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}

	public String getDoseType() {
		return doseType;
	}

	public void setDoseType(String doseType) {
		this.doseType = doseType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAccount() {
		return account;
	}

	public void setAccount(float account) {
		this.account = account;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRegistCode() {
		return registCode;
	}

	public void setRegistCode(int registCode) {
		this.registCode = registCode;
	}

	@Override
	public String toString() {
		return "ChPrescription{" + "id='" + id + '\'' + ", diagnosisCode='" + diagnosisCode + '\'' + ", drugName='"
				+ drugName + '\'' + ", unitPrice=" + unitPrice + ", unit='" + unit + '\'' + ", total=" + total
				+ ", frequence='" + frequence + '\'' + ", doseType='" + doseType + '\'' + ", account=" + account
				+ ", doctorName='" + doctorName + '\'' + ", date=" + date + ", specification='" + specification + '\''
				+ ", registCode=" + registCode + ", direction='" + direction + '\'' + '}';
	}
}
