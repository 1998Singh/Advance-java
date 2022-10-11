package com.evoke.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int eId;
	
	@Column (name ="Emp_name")
	private String name;
	
	@ManyToMany      // to implement relation blw two table.
	private List<Project>projects;

	public Emp() {
		super();
		
	}

	public Emp(int eId, String name, List<Project> projects) {
		super();
		this.eId = eId;
		this.name = name;
		this.projects = projects;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
	

}
