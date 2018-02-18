package com.sangeetha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String qualification = request.getParameter("qualification");
		String percentage = request.getParameter("percentage");
		
		if(firstName.isEmpty() || lastName.isEmpty() || age.isEmpty() || qualification.isEmpty() || percentage.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/pages/registration.jsp");
			out.println("<font color='red'>Please fill all the fields</font>");
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/success.jsp");
			String message = (String)request.getParameter("message");
			out.println("Message==" +message);
			rd.forward(request, response);
	 }	
   }
}
