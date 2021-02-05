package com.loginapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginapp.model.User;
import com.loginapp.model.UserNotFoundException;
import com.loginapp.model.UserService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
		
			User user=null;
			try{
				user=UserService.getUser(username, password);
				HttpSession httpSession=request.getSession();
				
				httpSession.setAttribute("user", user);
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}catch(UserNotFoundException ex) {
				response.sendRedirect("login.jsp?error=login failed");
			}
			
			
	}

}
