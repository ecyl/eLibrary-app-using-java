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

/**
 * Servlet implementation class ViewAllFav
 */
public class ViewAllFav extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavouriteModel fav = new FavouriteModel();
		// get the memberId from sessions
		HttpSession session = request.getSession();
		fav.setMemberId((int)session.getAttribute("memberId"));
		
		ArrayList<Book> myFavBooks = fav.displayMyFavBooks();
		session.setAttribute("myFavBooks", myFavBooks);
		
		response.sendRedirect("/ncsLibrary/ViewAllFav.jsp");
	}
}
