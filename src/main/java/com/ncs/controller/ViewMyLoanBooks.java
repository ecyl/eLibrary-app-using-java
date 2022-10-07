package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Loan;
import com.ncs.model.MemberBooks;

/**
 * Servlet implementation class ViewMyLoanBooks
 */
public class ViewMyLoanBooks extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBooks mb = new MemberBooks();
		
		// to retrieve the member id and username from the memberlogin jsp
		HttpSession session = request.getSession();
		mb.setMemberId((Integer) session.getAttribute("memberId"));
		ArrayList<Loan> myBooks = mb.displayMyLoanBooks();
		
		// to display all the borrowed books from this user
		session.setAttribute("myBooks", myBooks);
		response.sendRedirect("/ncsLibrary/returnBook.jsp");
	}
}
