package com.ncs.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberBooks {
	int memberId;
	int bookId;
	String borrowed;
	String returned;
	String memberName;
	String title;
	Date date;
	Date dueDate;
	int limit = 5;
	int counter;
	
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
	public String getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}
	public String getReturned() {
		return returned;
	}
	public void setReturned(String returned) {
		this.returned = returned;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public MemberBooks() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs_library", "root", "ecyl2461");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Loan> displayLoanBooks() {
		try {
			String s = "select * from member_books where borrowed=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, "true");
			res = pstmt.executeQuery();
			
			ArrayList<Loan> onLoan = new ArrayList<Loan>();
			
			while(res.next()) {
				memberId = res.getInt(1);
				bookId = res.getInt(2);
				memberName = res.getString(4);
				title = res.getString(5);
				date = res.getDate(6);
				dueDate = res.getDate(7);
				
				onLoan.add(new Loan(memberId, bookId, memberName, title, date, dueDate));
			}
			return onLoan;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void viewLoanDetails() {
		try {
			String s = "select * from member_books where book_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, bookId);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				memberId = res.getInt(1);
				memberName = res.getString(4);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void searchTitle() {
		try {
			// sets the title upon setting of the bookId
			String s = "select * from books where book_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, bookId);
			res = pstmt.executeQuery();
			if(res.next()) {
				title = res.getString(2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkBorrowStatus() {
		try {
			// check if the book has been borrowed
			String s = "select * from books where borrowed=? and book_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, "true");
			pstmt.setInt(2, bookId);
			res = pstmt.executeQuery();
			if(res.next()) {
				// book has been borrowed
				return true;
			}
			else {
				// book is available to borrow
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int borrow() {
		try {
			// update the borrow status in the books table 
			String s1 = "update books set borrowed=? where book_id=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1, "true");
			pstmt.setInt(2, bookId);
			int rows = pstmt.executeUpdate();
				
			// if borrow is successful add into member books table 
			// check the counter
			
			if(rows == 1) {
				if (counter < 5){
					String s2 = "insert into member_books values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(s2);
					pstmt.setInt(1, memberId);
					pstmt.setInt(2, bookId);
					pstmt.setString(3, "true");
					pstmt.setString(4, memberName);
					pstmt.setString(5, title);
					pstmt.setDate(6, date);
					pstmt.setDate(7, dueDate);
					
					int insert = pstmt.executeUpdate();
					counter+=1;
					System.out.println(counter);
					return insert;
				}
				else {
					return counter+=1;
				}
			}
			else {
					return -1;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int limit() {
		try {
			String s = "select * from member_books where member_id=? and borrowed=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, memberId);
			pstmt.setString(2, "true");
			res = pstmt.executeQuery();
			int count = 0;
			while(res.next()) {
				count+=1;
			}
			return limit-count;
			
		}
		catch(Exception e) {
			
		}
		return -1;
	}
	
	public int count() {
		try {
			String s = "select * from member_books where member_id=? and borrowed=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, memberId);
			pstmt.setString(2, "true");
			res = pstmt.executeQuery();
			int counter = 0;
			while(res.next()) {
				counter+=1;
				
			}
			return counter;
			
		}
		catch(Exception e) {
			
		}
		return -1;
	}
	
	public ArrayList<Loan> displayMyLoanBooks() {
		try {
			String s = "select * from member_books where borrowed=? and member_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, "true");
			pstmt.setInt(2, memberId);
			res = pstmt.executeQuery();
			
			ArrayList<Loan> myBooks = new ArrayList<Loan>();
			
			while(res.next()) {
				memberId = res.getInt(1);
				bookId = res.getInt(2);
				memberName = res.getString(4);
				title = res.getString(5);
				date = res.getDate(6);
				dueDate = res.getDate(7);
				
				myBooks.add(new Loan(memberId, bookId, memberName, title, date, dueDate));
			}
			return myBooks;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public int returnBook() {
		try {
			// update the borrow status in the books table 
			String s1 = "update books set borrowed=? where book_id=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1, "false");
			pstmt.setInt(2, bookId);
			int rows = pstmt.executeUpdate();
				
			// if return is successful delete from member_books table
			if(rows == 1) {
				String s2 = "delete from member_books where member_id=? and book_id=?";
				pstmt = con.prepareStatement(s2);
				pstmt.setInt(1, memberId);
				pstmt.setInt(2, bookId);
				
				int insert = pstmt.executeUpdate();
				counter-=1;
				return insert;
					
			}
			else {
					return -1;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
