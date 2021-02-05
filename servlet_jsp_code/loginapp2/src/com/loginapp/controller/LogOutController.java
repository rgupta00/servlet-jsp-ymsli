package com.loginapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// i need to log out the user
		//hey tomcat give me pre existing session
		HttpSession httpSession=request.getSession(false);
		if(httpSession!=null) {
			httpSession.invalidate();// i want to remove jsessionid from server side
		}
		
		response.sendRedirect("login.jsp?message=logout successfully");
	}


}
