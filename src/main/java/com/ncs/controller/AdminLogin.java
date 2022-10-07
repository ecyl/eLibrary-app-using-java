package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.AdminModel;
import com.ncs.model.Book;
import com.ncs.model.BookModel;
import com.ncs.model.MemberModel;

/**
 * Servlet implementation class AdminLogin
 */
//creates the comparator for comparing book id
	class BookComparator implements Comparator<Book> {
	    // override the compare() method
	    public int compare(Book l1, Book l2)
	    {
	        if (l1.getBookId() == l2.getBookId()) {
	            return 0;
	        }
	        else if (l1.getBookId() < l2.getBookId()) {
	            return 1;
	        }
	        else {
	            return -1;
	        }
	    }
	}
public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aun = request.getParameter("aun");
		String apwd = request.getParameter("apwd");
		
		HttpSession session = request.getSession(true);
		
		//Connect to the model
		AdminModel am = new AdminModel();
		//pass the parameters to the model 
		am.setAun(aun);
		am.setApwd(apwd);
		
		//check login details
		int x = am.login();
		
		if(x == 1) {
			//send redirect to the success page
			// send info about number of books in the library
			BookModel b = new BookModel();
			int count = b.getTotalBookCount();
			
			// to display all the books
			ArrayList<Book> book = b.displayBooks();
			// to display the books based on newly created
			Collections.sort(book, new BookComparator());
			
			// send info about total number of members
			MemberModel m = new MemberModel();
			int memCount = m.getTotalMembers();
			
			session.setAttribute("bookCount", count);
			session.setAttribute("memCount", memCount);
			session.setAttribute("book", book);
			response.sendRedirect("/ncsLibrary/welcomeAdmin.jsp");
		}
		else if (x == -1) {
			// send redirect to the wrong password page
			response.sendRedirect("/ncsLibrary/wrongPwd.html");
		}
		else {
			// send redirect to the wrong user page
			response.sendRedirect("/ncsLibrary/wrongUsername.html");
		}
	}
}
