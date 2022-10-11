package com.evoke.httpstatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Studentsinfo")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "roll_No")
    private int rollNo;
	@Column
	private String name;
	@Column
	private String stream;
	

	public Students() {
		super();
		
	}

	public Students(int rollNo, String name, String stream) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.stream = stream;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Students [rollNo=" + rollNo + ", name=" + name + ", stream=" + stream + "]";
	}

}
