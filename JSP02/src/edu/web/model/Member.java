package edu.web.model;

/**
 * @author wlsgh
 *
 */
public class Member {

	// 멤버 변수(필드, 프로퍼티)
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	

	
	public Member(String memberId, String memberPassword, String memberEmail) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
	}




	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}




	@Override
	public String toString() {
		
		// String format(format, args)
		// format: %s, %d, %f
		return String.format("Member{memberID: %s, memberPassword: %s, memberEmail: %s}", this.memberId, this.memberPassword, this.memberEmail);
	}
	
	
	
}
