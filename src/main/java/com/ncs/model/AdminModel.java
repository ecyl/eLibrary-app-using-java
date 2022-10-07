package com.ncs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminModel {
	String aun;
	String apwd;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	public String getAun() {
		return aun;
	}
	public void setAun(String aun) {
		this.aun = aun;
	}
	
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	// set the connection with the database
	public AdminModel() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs_library", "root", "ecyl2461");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login() {
		try {
			String s = "select * from admin where aun=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, aun);
			res = pstmt.executeQuery();
			
			//check if the admin username is correct
			if(res.next()) {
				if(apwd.equals(res.getString(2))) {
					// check if the admin password is correct
					return 1;
				}
				else {
					// check admin pass is wrong
					return 0;
				}
			}
			else {
				// check admin username is wrong
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
