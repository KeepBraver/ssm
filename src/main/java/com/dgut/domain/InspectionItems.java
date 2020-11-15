package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InspectionItems {
    private String id;
    private String item;
    private String deptName;
    private float unitPrice;
    private String unit;
    private int total;
    private float account;
    private String doctorAdvice;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private int registCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setDeptName(String depName) {
        this.deptName = depName;
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

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
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
        return "InspectionItems{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", deptName='" + deptName + '\'' +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", total=" + total +
                ", account=" + account +
                ", doctorAdvice='" + doctorAdvice + '\'' +
                ", date=" + date +
                ", registCode=" + registCode +
                '}';
    }
}
