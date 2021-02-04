package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class R2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public R2() {
		System.out.println("ctr of R2 is called...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init of R2 is called...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("inside servlet R2"+"<br>");
		out.print(request.getAttribute("key"));
	}

	
}
