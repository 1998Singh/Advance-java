package com.evoke.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	@Column(name = "Account_id")
	private int accountId;
	@Column(name = "Account_holdername")
	private String accountHoldername;
	@Column(name = "Account_no")
	private int accountNo;
	@ManyToOne
	private Bank bank;
	
	public Account() {
		super();
		
	}

	public Account(int accountId, String accountHoldername, int accountNo, Bank bank) {
		super();
		this.accountId = accountId;
		this.accountHoldername = accountHoldername;
		this.accountNo = accountNo;
		this.bank = bank;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountHoldername() {
		return accountHoldername;
	}

	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	
	
	
	
	

}
