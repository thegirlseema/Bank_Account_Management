package com.bank.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CLIENTDET")
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clientid;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
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
	
	@Column(name="EMAIL")
	private String email ;
	
	@Column(name="MOBILENO")
	private long mobileno ;
	
	@Column(name="CLIENTADDRESS")
	private String clientaddress ;
	
	public Client() {
		
	}

	
	public Client(long clientid, String firstname, String lastname, String username, String password,
			long accountbalance, long outstandingbalance, String doj, long withdraw, long deposit, long clientaccount,
			String email, long mobileno, String clientaddress) {
		super();
		this.clientid = clientid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.outstandingbalance = outstandingbalance;
		this.doj = doj;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.clientaccount = clientaccount;
		this.email = email;
		this.mobileno = mobileno;
		this.clientaddress = clientaddress;
	}
	

	public long getClientid() {
		return clientid;
	}


	public void setClientid(long clientid) {
		this.clientid = clientid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileno() {
		return mobileno;
	}


	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}


	public String getClientaddress() {
		return clientaddress;
	}


	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}


	@Override
	public String toString() {
	return "Name:"+this.firstname+" "+this.lastname+"\nUser name:"+this.username+"\nAccountNumber:"+this.clientaccount
			+"\nCurrent Balance:"+this.accountbalance;
	}
	
	}