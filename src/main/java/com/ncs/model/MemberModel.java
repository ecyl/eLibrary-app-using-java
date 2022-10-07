package com.ncs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class MemberModel {
	int memberId;
	String memberName;
	String memberPwd;
	String memberEmail;
	String memberDob;
	String Otp;
	String memberNewPwd;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberDob() {
		return memberDob;
	}
	public void setMemberDob(String memberDob) {
		this.memberDob = memberDob;
	}
	public String getOtp() {
		return Otp;
	}
	public void setOtp(String otp) {
		Otp = otp;
	}
	public String getMemberNewPwd() {
		return memberNewPwd;
	}
	public void setMemberNewPwd(String memberNewPwd) {
		this.memberNewPwd = memberNewPwd;
	}
	public MemberModel() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs_library", "root", "ecyl2461");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int register() {
		try {
			// check if there are duplicated email
			String s1 = "select * from members where member_email=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1, memberEmail);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				return -1;
			}
			else {
				String s2 = "insert into members (member_name, member_pwd, member_email, member_dob) values(?,?,?,?)";
				pstmt = con.prepareStatement(s2);
				pstmt.setString(1, memberName);
				
				// encrypt the password before storing in db
				String encryptedPwd = encryptPwd(memberPwd);
				pstmt.setString(2, encryptedPwd);
				pstmt.setString(3, memberEmail);
				pstmt.setString(4, memberDob);
				int rows = pstmt.executeUpdate();
				return rows;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	// password encryption 
	String encryptPwd(String memberPwd) {
		StringBuilder encrypted = new StringBuilder();
		int key = 6;
			
		for(char c : memberPwd.toCharArray()) {
			encrypted.append(Character.toChars(c+= key)) ;
		}
		return encrypted.toString();
	}
	//password decryption
	String decryptPwd(String memberPwd) {
		StringBuilder decrypted = new StringBuilder();
		int key = 6;
			
		for(char c : memberPwd.toCharArray()) {
			decrypted.append(Character.toChars(c-= key)) ;
		}
		return decrypted.toString();
	}
	
	public int login() {
		try {
			String s = "select * from members where member_email=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, memberEmail);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String decryptedPwd = decryptPwd(res.getString(3));
				if(decryptedPwd.equals(memberPwd)) {
					memberId = res.getInt(1);
					memberName = res.getString(2);
					memberDob = res.getString(5);
					return 1;
				}
				else {
					//wrong password
					return -1;
				}
			}
			else {
				// invalid email
				return 2;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int getTotalMembers() {
		try {
			String s = "select * from members";
			pstmt = con.prepareStatement(s);
			res = pstmt.executeQuery();
			
			ArrayList<Member> member = new ArrayList<Member>();
			
			while(res.next()) {
				memberId = res.getInt(1);
				memberName = res.getString(2);
				memberEmail = res.getString(4);
				
				member.add(new Member(memberId, memberName, memberEmail));
			}
			return member.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<Member> displayMembers(){
		try {
			String s = "select * from members";
			pstmt = con.prepareStatement(s);
			res = pstmt.executeQuery();
			
			ArrayList<Member> member = new ArrayList<Member>();
			
			while(res.next()) {
				memberId = res.getInt(1);
				memberName = res.getString(2);
				memberEmail = res.getString(4);
				
				member.add(new Member(memberId, memberName, memberEmail));
			}
			return member;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkPwd() {
		try {
			String s = "select * from members where member_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, memberId);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String decryptedPwd = decryptPwd(res.getString(3));
				if(decryptedPwd.equals(memberPwd)) {
					return true;
				}
				else {
					//wrong password
					return false;
				}
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int updatePwd() {
		try {
			String s = "update members set member_pwd=?, member_email=? where member_id=?";
			pstmt = con.prepareStatement(s);
			
			// encrypt the password before storing in db
			String encryptedPwd = encryptPwd(memberNewPwd);
			pstmt.setString(1, encryptedPwd);
			pstmt.setString(2, memberEmail);
			pstmt.setInt(3, memberId);
			int rows = pstmt.executeUpdate();
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateEmail() {
		try {
			String s = "update members set member_email=? where member_id=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, memberEmail);
			pstmt.setInt(2, memberId);
			int rows = pstmt.executeUpdate();
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int verifyDetails() {
		try {
			String s = "select * from members where member_name=? and member_email=? and member_dob=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberEmail);
			pstmt.setString(3, memberDob);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				// if all details are correct
				return 1;
			}
			// else return -1 for invalid credentials
			else {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int generateOtp() {
		try {
			 // It will generate 4 digit random Number.
		    // from 0 to 9999
		    Random rnd = new Random();
		    int number = rnd.nextInt(9999);
		    // this will convert any number sequence into 4 character.
		    Otp = String.format("%04d", number);
		    
		    // update into members table with the otp
		    String s = "update members set OTP=? where member_name=? and member_email=? and member_dob=?";
		    pstmt = con.prepareStatement(s);
		    pstmt.setString(1, Otp);
		    pstmt.setString(2, memberName);
			pstmt.setString(3, memberEmail);
			pstmt.setString(4, memberDob);
			int rows = pstmt.executeUpdate();
			
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int resetPassword() {
		try {
			// check if the OTP matches
			String s1 = "select * from members where member_name=? and member_email=? and member_dob=? and OTP=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberEmail);
			pstmt.setString(3, memberDob);
			pstmt.setString(4, Otp);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				// if OTP is correct then proceed to update password
				String s2 = "update members set member_pwd=? where member_name=? and member_email=? and member_dob=? and OTP=?";
				pstmt = con.prepareStatement(s2);
				
				// encrypt the password before storing in db
				String encryptedPwd = encryptPwd(memberPwd);
				pstmt.setString(1, encryptedPwd);
				
				pstmt.setString(2, memberName);
				pstmt.setString(3, memberEmail);
				pstmt.setString(4, memberDob);
				pstmt.setString(5, Otp);
				
				int rows = pstmt.executeUpdate();
				return rows;
			}
			else {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
