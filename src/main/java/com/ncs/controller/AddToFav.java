package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Book;
import com.ncs.model.FavouriteModel;
import com.ncs.model.MemberBooks;

/**
 * Servlet implementation class AddToFav
 */
public class AddToFav extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		FavouriteModel fav = new FavouriteModel();
		// get the memberId from sessions
		HttpSession session = request.getSession();
		fav.setMemberId((int)session.getAttribute("memberId"));
		fav.setBookId(bookId);
		
		fav.findBook();
		
		int x = fav.addToFav();
		if(x == 1) {
			// redirect to favourites show page
			ArrayList<Book> myFavBooks = fav.displayMyFavBooks();
			session.setAttribute("myFavBooks", myFavBooks);
			response.sendRedirect("/ncsLibrary/ViewAllFav.jsp");
		}
		else if (x == -1) {
			// send alert saying that the book has been add before;
			ArrayList<Book> myFavBooks = fav.displayMyFavBooks();
			session.setAttribute("myFavBooks", myFavBooks);
			response.sendRedirect("/ncsLibrary/addedToFav.jsp");
		}
		else {
			//redirect to error page
			response.sendRedirect("/ncsLibrary/error.html");
		}
		
		
	}
}
