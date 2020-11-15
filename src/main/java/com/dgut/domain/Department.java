package com.dgut.domain;

import java.util.List;

public class Department {
	private int deptId;
	private String deptName;
	private List<DoctorInfo> doctors;
	private String deptIntroduct;
	private String diagnosticRange;
	private String deptLeader;
	private String telephone;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<DoctorInfo> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorInfo> doctors) {
		this.doctors = doctors;
	}

	public String getDeptIntroduct() {
		return deptIntroduct;
	}

	public void setDeptIntroduct(String deptIntroduct) {
		this.deptIntroduct = deptIntroduct;
	}

	public String getDiagnosticRange() {
		return diagnosticRange;
	}

	public void setDiagnosticRange(String diagnosticRange) {
		this.diagnosticRange = diagnosticRange;
	}

	public String getDeptLeader() {
		return deptLeader;
	}

	public void setDeptLeader(String deptLeader) {
		this.deptLeader = deptLeader;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Department{" + "deptId=" + deptId + ", deptName='" + deptName + '\'' + ", doctors=" + doctors
				+ ", deptIntroduct='" + deptIntroduct + '\'' + ", diagnosticRange='" + diagnosticRange + '\''
				+ ", deptLeader='" + deptLeader + '\'' + ", telephone='" + telephone + '\'' + '}';
	}
}
