package com.cg.wallet.bean;

public class Account {

	private String mobileNo;
	private String name;
	private String emailId;
	private double balance;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account(String mobileNo, String name, String emailId, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.emailId = emailId;
		this.balance = balance;
	}
	public Account(){
		
	}
}

