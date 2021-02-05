package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "S1", urlPatterns = {"/S1.do"}, 
initParams = {
@WebInitParam(name = "adminName", value = "rajeev")})

public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String adminName=this.getServletConfig().getInitParameter("adminName");
		PrintWriter out=response.getWriter();
		out.print("hello servlet with annotation : "+adminName);
		
		
	}
}







