package com.calapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetClientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("get remote address of client:"+request.getRemoteAddr()+"<br>");
		out.print("client accept what content type:"+request.getContentType()+"<br>");
		out.print("client name:"+request.getRemoteHost()+"<br>");
		out.print("client port:"+request.getRemotePort()+"<br>");
		/*
		 * 		uri				url
		 * unique id			actual address of web page
		 */
		out.print("client req uri:"+request.getRequestURI()+"<br>");
		out.print("client req url:"+request.getRequestURL()+"<br>");
		
		
	}


}








