package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.MemberModel;

/**
 * Servlet implementation class VerifyDetails
 */
public class VerifyDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberDob = request.getParameter("memberDob").toString();
		
		MemberModel m = new MemberModel();
		m.setMemberName(memberName);
		m.setMemberEmail(memberEmail);
		m.setMemberDob(memberDob);
		
		// session creation to pass the data to jsp file 
		HttpSession session = request.getSession(true);
		
		// verify details
		int x = m.verifyDetails();
		
		if (x == 1) {
			// verified send redirect to success with alert of OTP
			int y = m.generateOtp();
			if(y==1) {
				String OTP = m.getOtp();
				session.setAttribute("OTP", OTP);
				session.setAttribute("memberName", m.getMemberName());
				session.setAttribute("memberEmail", m.getMemberEmail());
				session.setAttribute("memberDob", m.getMemberDob());
				// pass the otp to the alert and redirect to the reset password page
				response.sendRedirect("/ncsLibrary/resetPassword.jsp");
			}
			else {
				response.sendRedirect("/ncsLibrary/error.html");
			}
			
		}
		else if (x == -1) {
			// -1 invalid credentials
			response.sendRedirect("/ncsLibrary/invalidCredentials.html");
		}
		else {
			// 0 general error page
			response.sendRedirect("/ncsLibrary/error.html");
		}
	}

}
