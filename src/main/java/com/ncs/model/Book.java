package com.ncs.model;

public class Book {
	int bookId;
	String title;
	String author;
	String genre;
	String borrowed;
	String description;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Book(int bookId, String title, String author, String genre, String borrowed, String description) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.borrowed = borrowed;
		this.description = description;
	}
	
}
