package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public static boolean validate(String email,String password) {
		boolean status=false;
		
		
		try {
			// Initialize the JDBC driver
			Class.forName("org.postgresql.Driver");

			// Establish the connection
		Connection	conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test_DB", "postgres", "123456");
		PreparedStatement ps=conn.prepareStatement("select * from employee where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		status=rs.next();
		

		} catch (Exception e) {
			System.out.println(e);}
			
			return status;

		}
		
	}


