package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Book;
import com.ncs.model.Loan;
import com.ncs.model.MemberBooks;
import com.ncs.model.MemberModel;

/**
 * Servlet implementation class MemLogin
 */
public class MemLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberEmail = request.getParameter("memberEmail");
		String memberPwd = request.getParameter("memberPwd");
		
		// session creation to pass the data to jsp file 
		HttpSession session = request.getSession(true);
		
		MemberModel m = new MemberModel();
		m.setMemberEmail(memberEmail);
		m.setMemberPwd(memberPwd);
		
		int x = m.login();
		
		if(x == 1) {
			//if x == 1 login success
			
			// to capitalize the name
			String name = m.getMemberName();
			String s1 = name.substring(0, 1).toUpperCase();
			String memberName = s1 + name.substring(1);
			session.setAttribute("memberName", memberName);
			session.setAttribute("memberEmail", m.getMemberEmail());
			
			// to get the memberID for their stats in dashboard
			int memId = m.getMemberId();
			MemberBooks mb = new MemberBooks();
			mb.setMemberId(memId);
			int bookCount = mb.count();
//			System.out.println(bookCount);
			ArrayList<Loan> myBooks = mb.displayMyLoanBooks();
			
			session.setAttribute("memberId", memId);
			session.setAttribute("bookCount", bookCount);
			session.setAttribute("myBooks", myBooks);
			session.setAttribute("memberDob", m.getMemberDob());
			
			response.sendRedirect("/ncsLibrary/memberHome.jsp");
		}
		else if(x == -1) {
			// if x == -1 wrong password
			response.sendRedirect("/ncsLibrary/wrongPwd.html");
		}
		else if(x == 2) {
			// if x == -1 wrong password
			response.sendRedirect("/ncsLibrary/wrongUsername.html");
		}
		else {
			// if x == 0 error
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}
}
