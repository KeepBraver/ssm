package com.dgut.domain;

import java.io.Serializable;


public class DoctorInfo implements Serializable {
	private Integer doctorId;
	private String doctorName;
	private String sex;
	private String birthday;
	private String idNumber;
	private String address;
	private String phone;
	private String department;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DoctorInfo{" + "doctorId=" + doctorId + ", doctorName='" + doctorName + '\'' + ", sex='" + sex + '\''
				+ ", birthday='" + birthday + '\'' + ", idNumber='" + idNumber + '\'' + ", address='" + address + '\''
				+ ", phone='" + phone + '\'' + ", department='" + department + '\'' + '}';
	}
}
