package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.*;

/**
 * Servlet implementation class ViewLoanBooks
 */
public class ViewLoanBooks extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session creation to pass the data to jsp file 
		HttpSession session = request.getSession(true);
																		
		MemberBooks mb = new MemberBooks();		
		ArrayList<Loan> onLoan = mb.displayLoanBooks();
		
		// Arraylist is added to the session here so that can be passed to the view files
		session.setAttribute("onLoan", onLoan);
								
		if(onLoan.size() != 0) {
			response.sendRedirect("/ncsLibrary/ViewLoanBooks.jsp");
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
