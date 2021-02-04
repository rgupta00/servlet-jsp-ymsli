package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public MyServlet() {
		System.out.println("ctr of MyServlet is called...");
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init of MyServlet is called...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("inside servlet MyServlet"+"<br>");
	}


}
