package com.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//if somebody visit first time i want to say hello first time user
		//repeated user: how mabny time he has visited to my application
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		HttpSession httpSession=request.getSession();
		
		Integer counter=(Integer) httpSession.getAttribute("counter");
		if(counter==null) {
			out.print("welcome first time user!"+"<br>");
			httpSession.setAttribute("counter", new Integer(1));
		}else {
			out.print("we respect repeted customers" + counter);
			counter++;
			httpSession.setAttribute("counter", counter);
		}
		
		
		//		PrintWriter out=response.getWriter();
//		
//		response.setContentType("text/html");
//		//i need a session either give me new session or give pre existing session
//		HttpSession httpSession=request.getSession();
//		
//		out.print("is it a new session: :"+ httpSession.isNew()+"<br>");
//		out.print("session id(jsessionid): :"+ httpSession.getId()+"<br>");
//		out.print(" session cretion time: :"+ httpSession.getCreationTime()+"<br>");
//		out.print("when last he access the application: :"+ httpSession.getLastAccessedTime()+"<br>");
//		out.print("max inactive intervel :"+ httpSession.getMaxInactiveInterval()+"<br>");
//		
	
		
	}

}




