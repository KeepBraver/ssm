package com.dgut.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class EntryLibrary {
    private Integer id;
    private String invoiceCode;
    private String supplyCompany;
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date invoiceDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date entryDate;
    private String operator;
    private short status;
    
    public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	private List<DrugEntryOrder> drugEntryOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getSupplyCompany() {
        return supplyCompany;
    }

    public void setSupplyCompany(String supplyCompany) {
        this.supplyCompany = supplyCompany;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<DrugEntryOrder> getDrugEntryOrders() {
        return drugEntryOrders;
    }

    public void setDrugEntryOrders(List<DrugEntryOrder> drugEntryOrders) {
        this.drugEntryOrders = drugEntryOrders;
    }

    @Override
	public String toString() {
		return "EntryLibrary [id=" + id + ", invoiceCode=" + invoiceCode + ", supplyCompany=" + supplyCompany
				+ ", invoiceDate=" + invoiceDate + ", entryDate=" + entryDate + ", operator=" + operator + ", status="
				+ status + ", drugEntryOrders=" + drugEntryOrders + "]";
	}
}
