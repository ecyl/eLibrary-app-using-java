package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.MemberBooks;

/**
 * Servlet implementation class ReturnBook
 */
public class ReturnBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		// pass the member id via session
		HttpSession session = request.getSession();
		MemberBooks mb = new MemberBooks();
		
		mb.setMemberId((Integer) session.getAttribute("memberId"));
		mb.setBookId(bookId);
		int x = mb.returnBook();
		
		if(x==1) {
			//send redirect to the return book success page
			int bookCount = mb.count();
			session.setAttribute("bookCount", bookCount);
			response.sendRedirect("/ncsLibrary/returnBookSuccess.jsp");
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}
}
