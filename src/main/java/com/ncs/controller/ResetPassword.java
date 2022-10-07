package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.MemberModel;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Otp = request.getParameter("Otp");
		String memberPwd = request.getParameter("memberPwd");
		String conPwd = request.getParameter("conPwd");
		
		// get member details from session
		HttpSession session = request.getSession();
		
		// check if the passwords match before storing into the db
		if(memberPwd.equals(conPwd)) {
			// pass it to the member model
			MemberModel m = new MemberModel();
			m.setMemberName((String) session.getAttribute("memberName"));
			m.setMemberEmail((String) session.getAttribute("memberEmail"));
			m.setMemberDob((String) session.getAttribute("memberDob"));
			m.setOtp(Otp);
			m.setMemberPwd(memberPwd);
			
			// reset password method
			int x = m.resetPassword();
			if(x==1) {
				response.sendRedirect("/ncsLibrary/resetPasswordSuccess.jsp");
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
