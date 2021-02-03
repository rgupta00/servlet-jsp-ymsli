package com.iris.bookapp.model.persistance.book;

import java.sql.*;
import java.util.*;

import com.iris.bookapp.model.persistance.DataAccessExcetion;
import com.iris.bookapp.model.persistance.DbConnectionFactory;

public class BookDaoImpl implements BookDao {

	private Connection connection;

	public BookDaoImpl() {
		connection = DbConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		Book book = null;
		Statement stmt = null;
		try {

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("select * from books");

			while (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"),
						rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"), rs.getDate("pubDate"));
				books.add(book);
			}

		} catch (SQLException e) {
			throw new DataAccessExcetion("some jdbc problem", e);
		}

		return books;
	}

	@Override
	public Book add(Book book) {
		PreparedStatement pstmt = null;
		try {

			String INSERT_BOOK = "insert into books (isbn, title, author, price, pubDate )"
					+ " values (?,?,?,?,?)";
			pstmt = connection.prepareStatement(INSERT_BOOK,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getPrice());

			pstmt.setDate(5, new java.sql.Date(book.getPubDate().getTime()));
			int noOfRowsEffected = pstmt.executeUpdate();

			System.out.println(noOfRowsEffected);

			if (noOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				book.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book delete(int bookId) {

		PreparedStatement pstmt = null;
		try {

			String DELETE_BOOK = "delete from books where id=?";
			pstmt = connection.prepareStatement(DELETE_BOOK);
			pstmt.setInt(1, bookId);

			int noOfRowsEffected = pstmt.executeUpdate();

			System.out.println(noOfRowsEffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Book update(Book book) {

		Book bookToBeUpdated=getBookById(book.getId());
		if(bookToBeUpdated==null)
			throw new BookNotFoundException();
		
		PreparedStatement pstmt=null;
		try {
			
			String UPDATE_BOOK = "update books set price =? where id=?";
			pstmt=connection.prepareStatement
					(UPDATE_BOOK);
			pstmt.setDouble(1, book.getPrice());
			pstmt.setInt(2,book.getId());
			pstmt.executeUpdate();
		}catch(SQLException ex){
			throw new DataAccessExcetion("some jdbc hell", ex);
		}
		return book;
	}

	@Override
	public Book getBookById(int bookId) {

		Book book = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement("select * from books where id= ?");
			pstmt.setInt(1, bookId);
			
			ResultSet rs = pstmt.executeQuery();// RS

			if (rs.next()) {
				 book = new Book(rs.getInt("id"), rs.getString("isbn"),
						rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"), rs.getDate("pubDate"));
				System.out.println(book);
			}
			else
				throw new BookNotFoundException();

		} catch (SQLException e) {
			throw new DataAccessExcetion("jdbc problem", e);
		}
	
		return book;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return null;
	}
	

}
