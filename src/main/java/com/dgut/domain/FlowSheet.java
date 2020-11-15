package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FlowSheet {
    private String id;
    private String retreat;
    private float account;
    private String caseNum;
    private String chType;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String operator;
    private int registCode;
    private String chargeTypeId;

    public String getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(String chargeTypeId) {
        this.chargeTypeId = chargeTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRetreat() {
        return retreat;
    }

    public void setRetreat(String retreat) {
        this.retreat = retreat;
    }

    public float getAccount() {
        return account;
    }

    public void setAccount(float account) {
        this.account = account;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getChType() {
        return chType;
    }

    public void setChType(String chType) {
        this.chType = chType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getRegistCode() {
        return registCode;
    }

    public void setRegistCode(int registCode) {
        this.registCode = registCode;
    }

    @Override
    public String toString() {
        return "FlowSheet{" +
                "id='" + id + '\'' +
                ", retreat='" + retreat + '\'' +
                ", account=" + account +
                ", caseNum='" + caseNum + '\'' +
                ", chType='" + chType + '\'' +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", registCode=" + registCode +
                ", chargeTypeId='" + chargeTypeId + '\'' +
                '}';
    }
}
