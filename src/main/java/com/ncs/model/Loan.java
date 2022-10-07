package com.ncs.model;

import java.sql.Date;

public class Loan {
	int memberId;
	int bookId;
	String memberName;
	String title;
	Date date;
	Date dueDate;
	
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
	
	public Loan(int memberId, int bookId, String memberName, String title, Date date, Date dueDate) {
		super();
		this.memberId = memberId;
		this.bookId = bookId;
		this.memberName = memberName;
		this.title = title;
		this.date = date;
		this.dueDate = dueDate;
	}
	
	@Override
	public String toString() {
		return "Loan [memberId=" + memberId + ", bookId=" + bookId + ", memberName=" + memberName + ", title=" + title
				+ "]";
	}
}
