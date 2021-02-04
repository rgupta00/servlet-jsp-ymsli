package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Dog;


public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private Dog dog;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dog=(Dog)this.getServletContext().getAttribute("dog");
		System.out.println(dog.getName());
		System.out.println(dog.hashCode());
		getServletContext().removeAttribute("dog");
		System.out.println("doget of S2 is called...");
	}

}
