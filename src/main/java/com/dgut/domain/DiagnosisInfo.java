package com.dgut.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DiagnosisInfo {
    private String diagnosisCode;
    private String registCode;
    private int doctorId;
    private String presentIllness;
    private String passIllness;
    private String allergyIllness;
    private int systolic;
    private int diastolic;
    private int bloodSugar;
    private int pulse;
    private int weight;
    private String mainsuitInfo;
    private String symptom;
    private String diagnosticInfo;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date diagnosticDate;

    public String getMainsuitInfo() {
        return mainsuitInfo;
    }

    public void setMainsuitInfo(String mainsuitInfo) {
        this.mainsuitInfo = mainsuitInfo;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getPresentIllness() {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness) {
        this.presentIllness = presentIllness;
    }

    public String getPassIllness() {
        return passIllness;
    }

    public void setPassIllness(String passIllness) {
        this.passIllness = passIllness;
    }

    public String getAllergyIllness() {
        return allergyIllness;
    }

    public void setAllergyIllness(String allergyIllness) {
        this.allergyIllness = allergyIllness;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(int bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public Date getDiagnosticDate() {
        return diagnosticDate;
    }

    public void setDiagnosticDate(Date diagnosticDate) {
        this.diagnosticDate = diagnosticDate;
    }

    @Override
    public String toString() {
        return "DiagnosisInfo{" +
                "diagnosisCode='" + diagnosisCode + '\'' +
                ", registCode='" + registCode + '\'' +
                ", doctorId=" + doctorId +
                ", presentIllness='" + presentIllness + '\'' +
                ", passIllness='" + passIllness + '\'' +
                ", allergyIllness='" + allergyIllness + '\'' +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", bloodSugar=" + bloodSugar +
                ", pulse=" + pulse +
                ", weight=" + weight +
                ", mainsuitInfo='" + mainsuitInfo + '\'' +
                ", symptom='" + symptom + '\'' +
                ", diagnosticInfo='" + diagnosticInfo + '\'' +
                ", diagnosticDate=" + diagnosticDate +
                '}';
    }
}
