package com.evoke.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student12")
public class Student {
  
	@Id
	private int id;
	private String name;
	private String branch;
	private String city;

	public Student() {
		super();

	}

	public Student(int id, String name, String branch, String city) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.city = city;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", city=" + city + "]";
	}
	
	

}
