package com.evoke.spring;

public class Employee {

	private int empId;
	private String name;
	private String dep;

	public Employee() {
		super();

	}

	public Employee(int empId, String name, String dep) {
		super();
		this.empId = empId;
		this.name = name;
		this.dep = dep;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dep=" + dep + "]";
	}

}
