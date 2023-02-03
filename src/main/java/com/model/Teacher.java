package com.model;

public class Teacher {

	
	
	private int id;
	private String tchName;
	private String subject;
	private String Classname;
	
	public Teacher() {
		
	}


	public String getClassname() {
		return Classname;
	}


	public void setClassname(String classname) {
		Classname = classname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTchName() {
		return tchName;
	}


	public void setTchName(String tchName) {
		this.tchName = tchName;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Teacher(int id, String tchName, String subject, String classname) {
		super();
		this.id = id;
		this.tchName = tchName;
		this.subject = subject;
		Classname = classname;
	}


	public Teacher(String tchName, String subject, String classname) {
		super();
		this.tchName = tchName;
		this.subject = subject;
		Classname = classname;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tchName=" + tchName + ", subject=" + subject + ", Classname=" + Classname + "]";
	}

	
}
