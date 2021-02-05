package com.loginapp.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logic to get all the books details
		List<String> books=Arrays.asList("head first core java","rich dad poor dad");
		request.setAttribute("books", books);
		RequestDispatcher rd=request.getRequestDispatcher("showall.jsp");
		rd.forward(request, response);
	}

}
