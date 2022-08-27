package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modal.Address;
import modal.Employee;

public class DatabaseConfig {

	// Initialize the JDBC connection
	Connection connection = null;

	public void connect() {

		try {
			// Initialize the JDBC driver
			Class.forName("org.postgresql.Driver");

			// Establish the connection
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test_DB", "postgres", "123456");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insertEmployee(Employee employee) {

		String insertEmployee = "INSERT INTO public.employee(\r\n" + "	emp_id, name, email, password)\r\n"
				+ "	VALUES (?, ?, ?, ?);";

		String insertAddress = "INSERT INTO public.address(\r\n" + "	add_id, contact, city, state, zip, emp_id)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = connection.prepareStatement(insertEmployee);
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPassword());

			int employeeCount = ps.executeUpdate();
			ps.close();

			if (employeeCount > 0) {

				ps = connection.prepareStatement(insertAddress);

				ps.setInt(1, employee.getAddress().getAddid());
				ps.setString(2, employee.getAddress().getContact());
				ps.setString(3, employee.getAddress().getCity());
				ps.setString(4, employee.getAddress().getState());
				ps.setString(5, employee.getAddress().getZip());
				ps.setInt(6, employee.getEmpid());

				int addressCount = ps.executeUpdate();
				if (addressCount > 0)
					System.out.println("Employee got successfully inserted ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Employee getEmployeeByUserNameAndPassword(String userName, String password) {
		
//		String selectEmployeeSql="select e.emp_id,e.name,e.email,a.contact,a.add_id,a.city,a.state,a.zip from employee e\r\n"
//				+ "                inner join address a on a.emp_id=e.emp_id where email='+userName+'\r\n"
//				+ "				and password ='+password'";

		String selectEmployeeSql ="select e.emp_id,e.name,e.email,a.add_id,a.contact,a.city,a.state,a.zip from employee e inner join address a on e.emp_id=a.emp_id where e.email='"+userName+"' and e.password='"+password+"'";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectEmployeeSql);
			if (rs != null) {
				while (rs.next()) {

					Employee employee = new Employee();
					employee.setEmpid(rs.getInt(1));
					employee.setName(rs.getString(2));
					// employee.setPassword(rs.getString(3));
					employee.setEmail(rs.getString("email"));

					Address address = new Address();
					address.setAddid(rs.getInt(4));
					address.setContact(rs.getString(5));
					address.setCity(rs.getString(6));
					address.setState(rs.getString(7));
					address.setZip(rs.getString(8));

					employee.setAddress(address);
					return employee;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		 

		
	}

}
