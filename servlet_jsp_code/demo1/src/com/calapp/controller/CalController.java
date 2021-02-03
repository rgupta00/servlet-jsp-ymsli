package com.calapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalController() {
    	System.out.println("ctr is called...");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String aString= request.getParameter("a");
		String bString= request.getParameter("b");
		
		Integer sum=Integer.parseInt(aString)+ Integer.parseInt(bString);
		
		PrintWriter out=response.getWriter();
		out.print(sum);
	}

}
