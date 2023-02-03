package com.model;

public class Subject {

	
	private int id;
	private String sbjName;
	private String tchName;
	private String clsName;
	
	public Subject() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSbjName() {
		return sbjName;
	}

	public void setSbjName(String sbjName) {
		this.sbjName = sbjName;
	}

	public String getTchName() {
		return tchName;
	}

	public void setTchName(String tchName) {
		this.tchName = tchName;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public Subject(int id, String sbjName, String tchName, String clsName) {
		super();
		this.id = id;
		this.sbjName = sbjName;
		this.tchName = tchName;
		this.clsName = clsName;
	}

	public Subject(String sbjName, String tchName, String clsName) {
		super();
		this.sbjName = sbjName;
		this.tchName = tchName;
		this.clsName = clsName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", sbjName=" + sbjName + ", tchName=" + tchName + ", clsName=" + clsName + "]";
	}
	
	
}
