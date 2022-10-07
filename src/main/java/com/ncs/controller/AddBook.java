package com.ncs.controller;


import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.*;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookTitle = request.getParameter("bookTitle");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookGenre = request.getParameter("bookGenre");
		String bookDescription = request.getParameter("bookDescription");

		HttpSession session = request.getSession();
		// connect to book model
		BookModel bm = new BookModel();
		
		// pass parameters to model
		bm.setTitle(bookTitle);
		bm.setAuthor(bookAuthor);
		bm.setGenre(bookGenre);
		bm.setDescription(bookDescription);
		
		//check if the update was successful
		int rows = bm.addBook();
		
		if(rows ==1 ) {
			// redirect to successfully added new book page
			int count = bm.getTotalBookCount();
			// display all books
			ArrayList<Book> book = bm.displayBooks();
			// to display the books based on newly created
			Collections.sort(book, new BookComparator());
			
			session.setAttribute("bookCount", count);
			session.setAttribute("book", book);
			response.sendRedirect("/ncsLibrary/addBookSuccess.jsp");
		}
		else {
			// redirect to something went wrong page
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
