package com.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENTDETAIL")
public class Client{

	@Id
	@Column(name="CLIENTID")
	private long clientID;
	
	@Column(name="CLIENTNAME")
	private String clientName;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ACCOUNTBALANCE")
    private long accountBalance;
	
	@Column(name="OUTSTANDINGBALANCE")
    private long outstandingBalance;
	
	@Column(name="DOJ")
	private String doj;
	
	@Column(name="WITHDRAW")
	private long withdraw;
	
	@Column(name="DEPOSIT")
	private long deposit;
	
	@Column(name = "ACCOUNTNUMBER")
	private long clientAccount ;
	
	public Client() {
		
	}

	public Client(long clientID, String clientName, String userName, String password, long accountBalance,
			long outstandingBalance, String doj, long withdraw, long deposit, long clientAccount) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.userName = userName;
		this.password = password;
		this.accountBalance = accountBalance;
		this.outstandingBalance = outstandingBalance;
		this.doj = doj;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.clientAccount = clientAccount;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public long getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(long outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public long getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public long getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(long clientAccount) {
		this.clientAccount = clientAccount;
	}

	
	
}