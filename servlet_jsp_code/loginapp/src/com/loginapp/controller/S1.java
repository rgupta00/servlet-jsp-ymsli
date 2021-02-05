package com.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		// it will create a new session id=55
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("name", "raj");
		// how it works ? if cookies are enable at client side then it simple dont encode url
		//if cookies are disable then it will append jsession behind the url 
		
		//URLEncoder.encode("NAME", "UTF-8");
		String newUrl = response.encodeUrl("S2");

		out.println("Click <a href=\"" + newUrl + "\">here</a> for another servlet");
		// response.sendRedirect("S2");

	}

}
