package com.ncs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookModel {
	int bookId;
	String title;
	String author;
	String genre;
	String borrowed;
	String description;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
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
	
	// set the connection with the database
	public BookModel() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs_library", "root", "ecyl2461");
		}
		catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public int addBook() {
		try {
			String s = "insert into books (title, author, genre, borrowed, description) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, genre);
			pstmt.setString(4, "false");
			pstmt.setString(5, description);
			
			int rows = pstmt.executeUpdate();
			
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int removeBook() {
		try {
			String s = "delete from books where book_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, bookId);
			int rows = pstmt.executeUpdate();
			
			return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<Book> displayBooks() {
		try {
			String s = "select * from books";
			pstmt = con.prepareStatement(s);
			res = pstmt.executeQuery();
			
			ArrayList<Book> book = new ArrayList<Book>();
			
			while(res.next()) {
				bookId = res.getInt(1);
				title = res.getString(2);
				author = res.getString(3);
				genre = res.getString(4);
				borrowed = res.getString(5);
				description = res.getString(6);
				
				book.add(new Book(bookId, title, author, genre, borrowed, description));
			}
			return book;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getTotalBookCount() {
		try {
			String s = "select * from books";
			pstmt = con.prepareStatement(s);
			res = pstmt.executeQuery();
			
			ArrayList<Book> book = new ArrayList<Book>();
			
			while(res.next()) {
				bookId = res.getInt(1);
				title = res.getString(2);
				author = res.getString(3);
				genre = res.getString(4);
				borrowed = res.getString(5);
				description = res.getString(6);
				
				book.add(new Book(bookId, title, author, genre, borrowed, description));
			}
			return book.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
