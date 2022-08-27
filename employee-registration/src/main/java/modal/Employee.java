package modal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee {
	
	public static void main(String[] args) {
	Logger	logger =LogManager.getLogger(Employee.class);
		int i=0;
		while(i<100) {
			i++;
			logger.debug("This is Info msg");
			logger.info("This is Info msg");
			logger.warn("This is Info msg");
			logger.error("This is Info msg");
			
		}
	}

	private int empid;
	private String name;
	private String email;
	private String password;
	private Address address;

	public Employee() {
		super();
		
	}

	public Employee(int empid, String name, String email, String password, Address address) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + "]";
	}

}
