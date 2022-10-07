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

import com.ncs.model.Book;
import com.ncs.model.BookModel;

/**
 * Servlet implementation class RemoveBook
 */

public class RemoveBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		HttpSession session = request.getSession();
		BookModel bm = new BookModel();
		bm.setBookId(bookId);
		int x = bm.removeBook();
		
		if(x == 1) {
			// send info about number of books in the library
			int count = bm.getTotalBookCount();
			ArrayList<Book> book = bm.displayBooks();
			
			session.setAttribute("bookCount", count);
			session.setAttribute("book", book);
			response.sendRedirect("/ncsLibrary/removeBookSuccess.jsp");
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
