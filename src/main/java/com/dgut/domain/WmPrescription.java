package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WmPrescription {
    private String id;
    private String diagnosisCode; 
    private String drugName; 
    private String specification; 
    private float unitPrice; 
    private String doseType;
    private String unit;
    private String direction;
    private String frequence; 
    private int total;
    private float account;
    private String doctorName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private String registCode;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
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

    @Override
    public String toString() {
        return "WmPrescription{" +
                "id='" + id + '\'' +
                ", diagnosisCode='" + diagnosisCode + '\'' +
                ", drugName='" + drugName + '\'' +
                ", specification='" + specification + '\'' +
                ", unitPrice=" + unitPrice +
                ", doseType='" + doseType + '\'' +
                ", unit='" + unit + '\'' +
                ", direction='" + direction + '\'' +
                ", frequence='" + frequence + '\'' +
                ", total=" + total +
                ", account=" + account +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                ", registCode='" + registCode + '\'' +
                '}';
    }
}
