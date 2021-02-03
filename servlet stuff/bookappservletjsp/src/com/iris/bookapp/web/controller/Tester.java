package com.iris.bookapp.web.controller;
import java.util.List;

import com.iris.bookapp.model.persistance.book.Book;
import com.iris.bookapp.model.persistance.book.BookDao;
import com.iris.bookapp.model.persistance.book.BookDaoImpl;

public class Tester {
	
	public static void main(String[] args) {
		
		BookDao dao=new BookDaoImpl();
		List<Book> books=dao.getAll();
		for(Book b: books)
			System.out.println(b);
		
		
		/*List<Book> books=dao.getAll();
		for(Book b: books)
			System.out.println(b);
		
		Book book=new Book("QWAA3", "machine learning", "foo", 560.0, new Date());
		dao.add(book);
		System.out.println("----------after adding a book------------");
		books=dao.getAll();
		for(Book b: books)
			System.out.println(b);
			*/
		/*Book book2=null;
		try{
		 book2=dao.getBookById(500);
		System.out.println(book2);
		}catch(DataAccessExcetion e){
			System.out.println(e.getMessage());
			
		}catch(BookNotFoundException e){
			System.out.println("book not found");
		}
		*/
		//how to update :look for that book 
		// change the state of book in memory 
		// hit the database
		
		/*try{
			if(book2!=null){
				book2.setPrice(800.0);
				Book book=dao.update(book2);
				System.out.println(book);
			}
		
		}catch(DataAccessExcetion e){
			System.out.println(e.getMessage());
			
		}catch(BookNotFoundException e){
			System.out.println("book not found");
		}
		
		*/
	}

}






