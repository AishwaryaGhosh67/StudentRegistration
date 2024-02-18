package com.student.backend_sb.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

	@Id
	private String _id;
	private String studentName;
	private String studentAddress;
	private String mobile;
	
	public Student(String _id, String studentName, String studentAddress, String mobile) {
		super();
		this._id = _id;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.mobile = mobile;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Student [_id=" + _id + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", mobile=" + mobile + "]";
	}
	
	
	
}
