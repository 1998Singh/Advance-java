package com.evoke.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {

	@Id
	@Column(name = "Bank_id")
	private int bankId;
	@Column(name = "Bank_name")
	private String bankName;                         //   cascade = CascadeType.ALL
	@OneToMany(mappedBy = "bank",fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	private List<Account> account;

	public Bank() {
		super();

	}

	public Bank(int bankId, String bankName, List<Account> account) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.account = account;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

}
