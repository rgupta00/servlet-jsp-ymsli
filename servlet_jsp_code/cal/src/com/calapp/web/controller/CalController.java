package com.calapp.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calapp.model.service.Calculator;

@WebServlet("/cal")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("cal.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aString=request.getParameter("a");
		String bString=request.getParameter("b");
		Integer a=Integer.parseInt(aString);
		Integer b=Integer.parseInt(bString);
		
		Integer sum=Calculator.add(a, b);
		request.setAttribute("sum", sum);
		RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
		rd.forward(request, response);
		
		
	}

}
