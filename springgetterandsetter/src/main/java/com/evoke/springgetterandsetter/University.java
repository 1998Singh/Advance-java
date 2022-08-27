package com.evoke.springgetterandsetter;

//Dependency Injection by Setter Methods.

public class University {

	private String universityName;
	private int totalStudent;
	private int noOfCourse;

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}

	public int getNoOfCourse() {
		return noOfCourse;
	}

	public void setNoOfCourse(int noOfCourse) {
		this.noOfCourse = noOfCourse;
	}

	@Override
	public String toString() {
		return "University [universityName=" + universityName + ", totalStudent=" + totalStudent + ", noOfCourse="
				+ noOfCourse + "]";
	}

}
