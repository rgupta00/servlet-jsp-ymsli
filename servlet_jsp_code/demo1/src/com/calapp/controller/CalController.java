package com.calapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.calapp.model.Calculator;

public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalController() {
    	System.out.println("ctr is called...");
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//V
		
		//C: 
		/*
		 * 1. first to accept user req
		 * 2. get paramters and covert the data type if requerd, server side validation 
		 * 3. call model layer for processing the result
		 * 
		 */
		String aString= request.getParameter("a");
		String bString= request.getParameter("b");
		
		Integer a=Integer.parseInt(aString);
		Integer b=Integer.parseInt(bString);
		
		//model layer should calculate the result
		Integer sum=Calculator.sum(a, b);
		
		//controller should take the help of view layer ....
		//controller : servlet view : jsp
		//how to transfer data from controller to jsp
		//we need a scope
		
		//request scope , session scope(HttpSession) , application scope(ServletContext scope)
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("sum", sum);
		//RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		//rd.forward(request, response);
		response.sendRedirect("result.jsp");
	}

}
