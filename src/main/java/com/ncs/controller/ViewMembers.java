package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Member;
import com.ncs.model.MemberModel;

/**
 * Servlet implementation class ViewMembers
 */
public class ViewMembers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberModel m = new MemberModel();
		ArrayList<Member> member = m.displayMembers();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("member", member);
		
		response.sendRedirect("/ncsLibrary/ViewAllMembers.jsp");
	}

}
