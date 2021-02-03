package com.iris.bookapp.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.bookapp.model.persistance.user.User;
import com.iris.bookapp.model.persistance.user.UserDao;
import com.iris.bookapp.model.persistance.user.UserDaoImpl;
import com.iris.bookapp.model.persistance.user.UserNotFoundException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		try {
			User user = userDao.getUser(username, password);
			
			httpSession.setAttribute("user", user);
			//PRG :ok
			response.sendRedirect("BookController.do?action=allbook");
		} catch (UserNotFoundException ex) {
			httpSession.setAttribute("loginerror", "invalid username/password");
			//PRG: No 
			response.sendRedirect("index.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
		}
	}

	
}






