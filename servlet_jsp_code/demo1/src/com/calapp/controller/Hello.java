package com.calapp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	private String driverName=null;
	private String adminName=null;
	
	public Hello(){
		System.out.println(" defult ctr");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// from servletConfig i can pick ServletContext
		super.init(config);
		driverName=this.getInitParameter("driverName");
		adminName=getServletContext().getInitParameter("adminName");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(driverName);
		System.out.println(adminName);
	}


	@Override
	public void destroy() {
		
	}



}
