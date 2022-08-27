package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n =request.getParameter("username");
		String p =request.getParameter("userpass");
		
		if(LoginDao.validate(n, p)) {
			out.print("<h2> Exit Email & Password </h2>");
			out.print("<h2>  Email: "+n+"Password: "+p+" </h2>");
			
		}
		else {
			
			response.sendRedirect("index.jsp");
			System.out.println("Email and Passward does not exit");
			
		}
		
		out.close();
	}

}
