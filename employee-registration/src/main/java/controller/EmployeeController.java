package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseConfig;
import modal.Address;
import modal.Employee;
@WebServlet(name="register",urlPatterns = {"/register"})
public class EmployeeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		if(request!=null) {
			Employee emp = new Employee();
			emp.setEmpid(Integer.valueOf(request.getParameter("empid")));
			emp.setName(request.getParameter("name"));
			emp.setPassword(request.getParameter("password"));
			emp.setEmail(request.getParameter("email"));
			
			Address address = new Address(Integer.valueOf(request.getParameter("addid")), request.getParameter("contact"), request.getParameter("city"),
					request.getParameter("state"), request.getParameter("zip"));
			
			emp.setAddress(address);
			
			DatabaseConfig config = new DatabaseConfig();
			// Establish the connection
			config.connect();
			
			// inserting emp data
			config.insertEmployee(emp);
		}
		
	}

}
