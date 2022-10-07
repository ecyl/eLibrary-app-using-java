package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Loan;
import com.ncs.model.MemberBooks;

/**
 * Servlet implementation class BorrowBook
 */
public class BorrowBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		// to retrieve the member id and username from the memberlogin jsp
		HttpSession session = request.getSession();
		
		// setting all the existing details from the user
		MemberBooks mb = new MemberBooks();
		mb.setBookId(bookId);
		mb.setMemberId((Integer) session.getAttribute("memberId"));
		mb.setMemberName((String)session.getAttribute("memberName"));
		
		// to insert the date borrowed
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
//		System.out.println(sqldate);
		mb.setDate(sqldate);
		
		// to indicate the due date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date datePlus7 = cal.getTime();
		java.sql.Date dueDate = new java.sql.Date(datePlus7.getTime());
		mb.setDueDate(dueDate);
		
//		System.out.println(dueDate);
		
		int bookCount = (int) session.getAttribute("bookCount");
		mb.setCounter(bookCount);
		
		// to set the title based on the bookid
		mb.searchTitle();
		
		int x = mb.limit();
		
		// check the limit before borrowing
		if(x == 0) {
			// borrowed too many books
			// pass the book array 
			response.sendRedirect("/ncsLibrary/exceedBorrowLimit.jsp");
			}
		else{
			mb.borrow();
				
			bookCount = mb.getCounter();
			session.setAttribute("bookCount", bookCount);
			
			// send redirect to the success page with alert
			// display all loan books
			ArrayList<Loan> myBooks = mb.displayMyLoanBooks();
			session.setAttribute("myBooks", myBooks);
			response.sendRedirect("/ncsLibrary/borrowBookSuccess.jsp");
		}
		
	}

}
