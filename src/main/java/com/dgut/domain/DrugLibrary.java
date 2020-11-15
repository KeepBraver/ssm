package com.dgut.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DrugLibrary {
    private String drugCode;
    private String drugName;
    private String batchNum;
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validityDate;
    private String unit;
    private int libraryNum;
    private float unitPrice;
    private String operator;
    private String drugLibraryType;
    private DrugInfo drugInfo;

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

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(int libraryNum) {
        this.libraryNum = libraryNum;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDrugLibraryType() {
        return drugLibraryType;
    }

    public void setDrugLibraryType(String drugLibraryType) {
        this.drugLibraryType = drugLibraryType;
    }

    public DrugInfo getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(DrugInfo drugInfo) {
        this.drugInfo = drugInfo;
    }

    @Override
    public String toString() {
        return "DrugLibrary{" +
                "drugCode='" + drugCode + '\'' +
                ", drugName='" + drugName + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", validityDate=" + validityDate +
                ", unit='" + unit + '\'' +
                ", libraryNum=" + libraryNum +
                ", unitPrice=" + unitPrice +
                ", operator='" + operator + '\'' +
                ", drugLibraryType='" + drugLibraryType + '\'' +
                ", drugInfo=" + drugInfo +
                '}';
    }
}
