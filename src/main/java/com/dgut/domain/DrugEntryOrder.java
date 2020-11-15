package com.dgut.domain;

public class DrugEntryOrder {
    public String id;
    public String entryLibraryId;
    public String drugCode;
    public int entryNum;
    public DrugInfo drugInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntryLibraryId() {
        return entryLibraryId;
    }

    public void setEntryLibraryId(String entryLibraryId) {
        this.entryLibraryId = entryLibraryId;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public int getEntryNum() {
        return entryNum;
    }

    public void setEntryNum(int entryNum) {
        this.entryNum = entryNum;
    }

    public DrugInfo getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(DrugInfo drugInfo) {
        this.drugInfo = drugInfo;
    }

    @Override
    public String toString() {
        return "DrugEntryOrder{" +
                "id='" + id + '\'' +
                ", entryLibraryId='" + entryLibraryId + '\'' +
                ", drugCode='" + drugCode + '\'' +
                ", entryNum=" + entryNum +
                ", drugInfo=" + drugInfo +
                '}';
    }
}
