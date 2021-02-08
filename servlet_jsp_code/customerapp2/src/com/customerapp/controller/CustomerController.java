package com.customerapp.controller;

import java.util.*;
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

import com.customerapp.customer.Customer;
import com.customerapp.dao.ConnectionFactory;
import com.customerapp.dao.DataAccessException;
import com.customerapp.service.CustomerService;
import com.customerapp.service.CustomerServiceImpl;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		HttpSession httpSession=request.getSession();
		System.out.println("-----------#####-------------");
		System.out.println(httpSession.getAttribute("user"));
		System.out.println("-----------#####-------------");
		if (action.equalsIgnoreCase("showall")) {
			List<Customer> customers = customerService.allCustomers();
			request.setAttribute("customers", customers);
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		} else if (action.equalsIgnoreCase("add")) {
			// Why not resp.sendRedict
			request.getRequestDispatcher("addcustomer.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			customerService.deleteCustomer(id);
			response.sendRedirect("custcontroller.do?action=showall");

		} else if (action.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			Customer customer = customerService.getCustomerById(id);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("updatecustomer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String dobString = request.getParameter("dob");
		String email = request.getParameter("email");

		SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("-------------------------------------");
		System.out.println(id);
		System.out.println("-------------------------------------");

		Date dob = null;
		try {
			dob = formate.parse(dobString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Customer customer = new Customer(name, address, mobile, email, dob);

		// new customer rec
		if (id == 0) {
			try {
				customer = customerService.addCustomer(customer);
			} catch (DataAccessException ex) {
				ex.printStackTrace();
			}

		} 
		//for update
		else {
			Customer customer2 = customerService.getCustomerById(id);
			customer2.setAddress(address);
			customer2.setEmail(email);
			customer2.setMobile(mobile);
			customerService.updateCustomer(id, customer2);
		}

		response.sendRedirect("custcontroller.do?action=showall");
	}

}
