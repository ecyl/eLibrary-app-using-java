package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.MemberModel;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// member can only update email and password
		String memberPwd = request.getParameter("memberPwd");
		String memberNewPwd = request.getParameter("memberNewPwd");
		String conPwd = request.getParameter("conPwd");
		String memberEmail = request.getParameter("memberEmail");
		
		HttpSession session = request.getSession();
		// get member's name and dob from session for verification
		MemberModel m = new MemberModel();
		
		int memberId =(int)session.getAttribute("memberId");
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		
		// check if the current password is correct before proceeding with update
		// check if the passwords match before storing in database
		
		// member can change email
		// member can change pwd
		
		if(m.checkPwd() && memberNewPwd.equals(conPwd)) {
			if(memberNewPwd.isEmpty()) {
				m.setMemberEmail(memberEmail);
				
				int x = m.updateEmail();
					
				if(x == 1) {
					// send all the new information to the sessions
					session.setAttribute("memberEmail", memberEmail);
					response.sendRedirect("/ncsLibrary/updateDetailsSuccess.jsp");
				}
				else {
					response.sendRedirect("/ncsLibrary/error.html");
				}
			}
			else {
				m.setMemberNewPwd(memberNewPwd);
				m.setMemberEmail((String) session.getAttribute("memberEmail"));
				
				int y = m.updatePwd();
				
				if(y == 1) {
					// send all the new information to the sessions
					session.setAttribute("memberEmail", memberEmail);
					response.sendRedirect("/ncsLibrary/updateDetailsSuccess.jsp");
				}
				else {
					response.sendRedirect("/ncsLibrary/error.html");
				}
			}
			
		}
		else {
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}
}
