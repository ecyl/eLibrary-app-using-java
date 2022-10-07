package com.ncs.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncs.model.MemberModel;

/**
 * Servlet implementation class MemRegister
 */
public class MemRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("memberName");
		String memberDob = request.getParameter("memberDob").toString();
		String memberPwd = request.getParameter("memberPwd");
		String conPwd = request.getParameter("conPwd");
		String memberEmail = request.getParameter("memberEmail");
		
		// get today's date (year)
//		Date currentDate = new Date();
//		System.out.println(java.time.LocalDate.now());
		
		// get member's dob (year)
		// age = today's date - members dob (year)
		// if age>=18 => proceed with the updates in the database
		// else => redirect to a page indicating that the user is too young (or not of age)
		
		// check if the passwords match before storing in database
		if(memberPwd.equals(conPwd)) {
			// pass the params to the member model
			MemberModel m = new MemberModel();
			m.setMemberName(memberName);
			m.setMemberPwd(memberPwd);
			m.setMemberEmail(memberEmail);
			m.setMemberDob(memberDob);
			
			int x = m.register();
			if(x == 1) {
				response.sendRedirect("/ncsLibrary/registrationSuccess.jsp");
			}
			else if(x == -1) {
				// email is taken
				response.sendRedirect("/ncsLibrary/duplicateEmail.html");
			}
			else {
				response.sendRedirect("/ncsLibrary/error.html");
			}
		}
		else {
			// password mismatch error
			response.sendRedirect("/ncsLibrary/pwdMisMatch.html");
		}
	}

}
