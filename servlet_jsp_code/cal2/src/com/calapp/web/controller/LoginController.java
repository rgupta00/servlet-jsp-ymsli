package com.calapp.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.calapp.model.service.User;
import com.calapp.model.service.UserNotFoundException;
import com.calapp.model.service.UserService;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error=request.getParameter("error");
		if(error!=null) {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp?error=login failed..")
		.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp")
			.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession httpSession=request.getSession();
		try {
		User user=UserService.validateUser(username, password);
		
		httpSession.setAttribute("user", user);
		response.sendRedirect("cal.do");
		
		}catch(UserNotFoundException ex) {
			httpSession.setAttribute("error", ex.getMessage());
			response.sendRedirect("login?error=user in inalid");
		}
	}

}
