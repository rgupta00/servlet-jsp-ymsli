package com.customerapp.controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerapp.dao.ConnectionFactory;
import com.customerapp.dao.Customer;
import com.customerapp.dao.DataAccessException;
import com.customerapp.service.CustomerService;
import com.customerapp.service.CustomerServiceImpl;

public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService=new CustomerServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String dobString = request.getParameter("dob");
		String email = request.getParameter("email");

		SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");

		Date dob = null;
		try {
			dob = formate.parse(dobString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Customer customer = new Customer(name, address, mobile, email, dob);
		try{
			customer =customerService.addCustomer(customer);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
		}
		//only sol for time being...we have to increae the scope of this variable
		
		HttpSession httpSession=request.getSession();
		
		httpSession.setAttribute("customer", customer);
		//i have to use here ie sendRedirect
		
		//RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		//rd.forward(request, response);
		
		response.sendRedirect("success.jsp");
	}

}
