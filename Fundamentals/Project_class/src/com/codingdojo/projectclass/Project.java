package com.codingdojo.projectclass;

public class Project {
	private String name;
	private String description;
	
	public Project() {
	}
	
	public Project(String name) {
		this.setName(name);
	}

	public Project(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public String elevatorPitch() {
		return name + " : " + description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
