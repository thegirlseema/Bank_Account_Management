package com.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client{

	@Id
	@Column(name="CLIENTID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private String clientID;
	
	@Column(name="CLIENTNAME")
	private String clientName;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name = "ACCOUNTNUMBER")
	private int clientAccount ;
	
	@Column(name="ACCOUNT_BALANCE")
    private int accountBalance;
	
	@Column(name="OUTSTANDING_BALANCE")
    private int outstandingBalance;
	
	@Column(name="DOJ")
	private String doj;

	public Client() {
		
	}

	public Client(String clientID, String clientName, String userName, String password, int clientAccount,
			int accountBalance, int outstandingBalance, String doj) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.userName = userName;
		this.password = password;
		this.clientAccount = clientAccount;
		this.accountBalance = accountBalance;
		this.outstandingBalance = outstandingBalance;
		this.doj = doj;
	}



	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
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

	public int getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(int clientAccount) {
		this.clientAccount = clientAccount;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(int outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}	
	
}