package com.ncs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FavouriteModel {
	int memberId;
	int bookId;
	String title;
	String author;
	String genre;
	String description;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FavouriteModel() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs_library", "root", "ecyl2461");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findBook() {
		try {
			String s = "select * from books where book_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, bookId);
			res = pstmt.executeQuery();
			if(res.next()) {
				title = res.getString(2);
				author = res.getString(3);
				genre = res.getString(4);
				description = res.getString(6);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addToFav() {
		try {
			// check if the book as been fav before
			String s1 = "select * from favourites where member_id=? and book_id=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setInt(1, memberId);
			pstmt.setInt(2, bookId);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				return -1;
			}
			else {
				String s = "insert into favourites values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(s);
				pstmt.setInt(1, memberId);
				pstmt.setInt(2, bookId);
				pstmt.setString(3, title);
				pstmt.setString(4, author);
				pstmt.setString(5, genre);
				pstmt.setString(6, description);
				int rows = pstmt.executeUpdate();
				
				return rows;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Book> displayMyFavBooks() {
		try {
			String s = "select * from favourites where member_id=?";
			// display the title, author, genre and description from the books table based
			// on the bookid 
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, memberId);
			
			res = pstmt.executeQuery();
			// SELECT *
			// FROM favourites
			// INNER JOIN books
			// ON favourites.book_id = books.book_id;
			ArrayList<Book> myFavBooks = new ArrayList<Book>();
			
			while(res.next()) {
				bookId = res.getInt(2);
				title = res.getString(3);
				author = res.getString(4);
				genre = res.getString(5);
				description = res.getString(6);
				
				myFavBooks.add(new Book(bookId, title, author, genre, "false", description));
			}
			return myFavBooks;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public int removeFav() {
		try {
			String s = "delete from favourites where book_id=? and member_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, memberId);
			int rows = pstmt.executeUpdate();
			
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
