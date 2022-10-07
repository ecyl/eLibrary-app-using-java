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
 * Servlet implementation class ViewLoanDetails
 */
public class ViewLoanDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		HttpSession session = request.getSession();
		MemberBooks mb = new MemberBooks();
		mb.setBookId(bookId);
		
		mb.viewLoanDetails();
		
		session.setAttribute("memberId",mb.getMemberId());
		session.setAttribute("memberName",mb.getMemberName());
		
		response.sendRedirect("/ncsLibrary/viewLoanDetails.jsp");
		
	}
}
