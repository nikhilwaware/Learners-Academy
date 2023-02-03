package com.model;

import com.model.Teacher;

public class Student {


	private int id;
	private String stdName;
	private String rollNo;
	private String Classname;
	
	public Student() {
		
	}

	
	public String getClassname() {
		return Classname;
	}


	public void setClassname(String classname) {
		this.Classname = classname;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStdName() {
		return stdName;
	}


	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	public Student(int id, String stdName, String rollNo, String classname) {
		super();
		this.id = id;
		this.stdName = stdName;
		this.rollNo = rollNo;
		this.Classname = classname;
	}


	public Student(String stdName, String rollNo, String classname) {
		super();
		this.stdName = stdName;
		this.rollNo = rollNo;
		this.Classname = classname;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", stdName=" + stdName + ", rollNo=" + rollNo + ", Classname=" + Classname + "]";
	}


	
	
	
}
