package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Book;
import com.ncs.model.BookModel;

/**
 * Servlet implementation class ViewAllBooks
 */
public class ViewAllBooks extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookModel bm = new BookModel();
		ArrayList<Book> allBooks = bm.displayBooks();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("allBooks", allBooks);
		
		if(allBooks.size() != 0) {
			response.sendRedirect("/ncsLibrary/ViewAllBooks.jsp");
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
