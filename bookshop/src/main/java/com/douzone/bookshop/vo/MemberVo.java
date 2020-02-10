package com.douzone.bookshop.vo;

public class MemberVo {

	private long mno;
	private String name;
	private String phone;
	private String email;
	private String pass;

	public long getMno() {
		return mno;
	}

	public void setMno(long mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "MemberVo [mno=" + mno + ", name=" + name + ", phone=" + phone + ", email=" + email + ", pass=" + pass
				+ "]";
	}

}
