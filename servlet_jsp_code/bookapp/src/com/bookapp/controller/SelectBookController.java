package com.bookapp.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.BookService;

public class SelectBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SelectBookController() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//take req from the user
		String topic=request.getParameter("topic");
		
		//call model layer
		List<String> booksNames=BookService.getBookSuggestion(topic);
		
		// put the data of processing in the "request" scope and then do request dispaching to a jsp
		
		request.setAttribute("booksNames", booksNames);
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		//rd.include(request, response);
		
	}

}






