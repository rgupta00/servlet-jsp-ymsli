package com.iris.bookapp.model.persistance.book;
import java.util.List;
//aka contract bw two parites
public interface BookDao {
	public List<Book> getAll();
	public Book add(Book book);
	public Book delete(int bookId);
	public Book update(Book book);
	public Book getBookById(int bookId);
	public Book getBookByIsbn(String isbn);	

}
