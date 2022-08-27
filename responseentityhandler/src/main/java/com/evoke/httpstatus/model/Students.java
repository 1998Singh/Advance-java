package com.evoke.httpstatus.model;

public class Students {

	private int rollNo;
	private String name;
	private String stream;

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
