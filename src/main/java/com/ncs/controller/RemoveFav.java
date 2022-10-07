package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.FavouriteModel;

/**
 * Servlet implementation class RemoveFav
 */
public class RemoveFav extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		FavouriteModel fav = new FavouriteModel();
		// get the memberId from sessions
		HttpSession session = request.getSession();
		fav.setMemberId((int)session.getAttribute("memberId"));
		fav.setBookId(bookId);
		
		int x = fav.removeFav();
		if(x == 1) {
			response.sendRedirect("/ncsLibrary/memberHome.jsp");
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
