package com.iris.bookapp.model.persistance.book;

import java.util.Date;
//DTO=> used to transfer object from one layer to another!
public class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private Double price;
	private Date pubDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public Book(int id, String isbn, String title, String author, Double price,
			Date pubDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
	}
	public Book() {}
	
	public Book(String isbn, String title, String author, Double price,
			Date pubDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title
				+ ", author=" + author + ", price=" + price + ", pubDate="
				+ pubDate + "]";
	}
	
	
	
	
	
}
