package com.iris.bookapp.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.bookapp.model.persistance.DataAccessExcetion;
import com.iris.bookapp.model.persistance.book.Book;
import com.iris.bookapp.model.persistance.book.BookDao;
import com.iris.bookapp.model.persistance.book.BookDaoImpl;

@WebServlet("/BookController.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDao dao = new BookDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if ("allbook".equals(action)) {
			List<Book> books=null;
			try{
			books = dao.getAll();
			}catch(DataAccessExcetion ex){
				ex.printStackTrace();
			}
			request.setAttribute("books", books);
			RequestDispatcher rd = request
					.getRequestDispatcher("show_books.jsp");
			rd.forward(request, response);
		} else if ("add".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("add_book.jsp");
			rd.forward(request, response);
		}else if("delete".equals(action)){
			Integer id=Integer.parseInt(request.getParameter("id").trim());
			try{
				dao.delete(id);
			}catch(DataAccessExcetion ex){
				ex.printStackTrace();
			}
			response.sendRedirect("BookController.do?action=allbook");
		}else if("update".equals(action)){
			Integer id=Integer.parseInt(request.getParameter("id").trim());
			System.out.println("--------------------");
			System.out.println(id);
			Book book=dao.getBookById(id);
			request.setAttribute("book", book);
		//	response.sendRedirect("add_book.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("add_book.jsp");
			rd.forward(request, response);
		}
	}
	//PRG design pattern: post-->redirect to get?
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idString=request.getParameter("id");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String priceString = request.getParameter("price");

		String pubDateString = request.getParameter("pubDate");
		
		Double price=null;
		Date pubDate=null;
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		try{
			price=Double.parseDouble(priceString);
			pubDate=df.parse(pubDateString);
		}catch(Exception ex){
			
		}
		//null vs ""
		if("".equals(idString)){
			Book book =new Book(isbn, title, author, price, pubDate);
			dao.add(book);
		}else {
			Integer id=Integer.parseInt(idString.trim());
			Book book =new Book(id, isbn, title, author, price, pubDate);
			dao.update(book);
		}

		response.sendRedirect("BookController.do?action=allbook");
	}
}












