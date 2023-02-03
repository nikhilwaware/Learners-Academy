package com.model;

public class ClassDetails {

	private int id;
	private String name;
	private String Section;
	
	public ClassDetails() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public ClassDetails(int id, String name, String section) {
		super();
		this.id = id;
		this.name = name;
		Section = section;
	}

	public ClassDetails(String name, String section) {
		super();
		this.name = name;
		Section = section;
	}

	@Override
	public String toString() {
		return "ClassDetails [id=" + id + ", name=" + name + ", Section=" + Section + "]";
	}
	
	
}
