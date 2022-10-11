package com.evoke.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pId;

	@Column(name = "Project_id")
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Emp> emps;

	public Project() {
		super();

	}

	public Project(int pId, String projectName, List<Emp> emps) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.emps = emps;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}
