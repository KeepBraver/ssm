package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 鎸傚彿淇℃伅琛�
 */
public class RegisterInfo {

    private Integer registCode;
    private String patientName;
    private String fsDiagnosis;
    private String registType;
    private String costType;
    private String deptName;
    private String doctorName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private Float regCost;
    private String operator;
    private String registerStatus;
    public PatientInfo patientInfo;
    private Integer patientId;

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getFsDiagnosis() {
        return fsDiagnosis;
    }

    public void setFsDiagnosis(String fsDiagnosis) {
        this.fsDiagnosis = fsDiagnosis;
    }

    public String getRegistType() {
        return registType;
    }

    public void setRegistType(String registType) {
        this.registType = registType;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public Float getRegCost() {
        return regCost;
    }

    public void setRegCost(Float regCost) {
        this.regCost = regCost;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "registCode=" + registCode +
                ", patientName='" + patientName + '\'' +
                ", fsDiagnosis='" + fsDiagnosis + '\'' +
                ", registType='" + registType + '\'' +
                ", costType='" + costType + '\'' +
                ", deptName='" + deptName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", regCost=" + regCost +
                ", operator='" + operator + '\'' +
                ", registerStatus='" + registerStatus + '\'' +
                ", patientInfo=" + patientInfo +
                ", patientId=" + patientId +
                '}';
    }
}
