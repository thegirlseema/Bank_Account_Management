package com.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTDETAIL")
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clientid;
	
	@Column(name="CLIENTNAME")
	private String clientname;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ACCOUNTBALANCE")
    private long accountbalance;
	
	@Column(name="OUTSTANDINGBALANCE")
    private long outstandingbalance;
	
	@Column(name="DOJ")
	private String doj;
	
	@Column(name="WITHDRAW")
	private long withdraw;
	
	@Column(name="DEPOSIT")
	private long deposit;
	
	@Column(name="ACCOUNTNUMBER")
	private long clientaccount ;
	
	public Client() {
		
	}

	public Client(long clientid, String clientname, String username, String password, long accountbalance,
			long outstandingbalance, String doj, long withdraw, long deposit, long clientaccount) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.outstandingbalance = outstandingbalance;
		this.doj = doj;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.clientaccount = clientaccount;
	}

	public long getClientid() {
		return clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(long accountbalance) {
		this.accountbalance = accountbalance;
	}

	public long getOutstandingbalance() {
		return outstandingbalance;
	}

	public void setOutstandingbalance(long outstandingbalance) {
		this.outstandingbalance = outstandingbalance;
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

	public long getClientaccount() {
		return clientaccount;
	}

	public void setClientaccount(long clientaccount) {
		this.clientaccount = clientaccount;
	}
	
	}