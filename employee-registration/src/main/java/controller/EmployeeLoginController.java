package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseConfig;
import modal.Employee;
@WebServlet(name="login",urlPatterns={"/login"})
public class EmployeeLoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			DatabaseConfig config = new DatabaseConfig();
			config.connect();

			Employee emp = config.getEmployeeByUserNameAndPassword(request.getParameter("userName"),
					request.getParameter("password"));
			if (emp != null) {
				request.setAttribute("empData", emp);
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "Employee Does not exit");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
	}

}
