package com.ncs.model;

public class Member {
	int memberId;
	String memberName;
	String memberEmail;
	
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
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Member(int memberId, String memberName, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}
}
