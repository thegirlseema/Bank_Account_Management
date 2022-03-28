package com.bank.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Client Entity Class With Annotation 
 * To Define The Table Structure Of Client Database table
 */
@Entity
@Table(name="CLIENTDET")
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clientid;
	
	//Mapping to the column name =>FIRSTNAME
	@Column(name="FIRSTNAME")
	private String firstname;
	
	//Mapping to the column name =>LASTNAME
	@Column(name="LASTNAME")
	private String lastname;
	
	//Mapping to the column name =>USERNAME
	@Column(name="USERNAME")
	private String username;
	
	//Mapping to the column name =>PASSWORD
	@Column(name="PASSWORD")
	private String password;
	
	//Mapping to the column name =>ACCOUNTBALANCE
	@Column(name="ACCOUNTBALANCE")
    private long accountbalance;
	
	//Mapping to the column name =>OUTSTANDINGBALANCE
	@Column(name="OUTSTANDINGBALANCE")
    private long outstandingbalance;
	
	//Mapping to the column name =>DOJ
	@Column(name="DOJ")
	private String doj;
	
	//Mapping to the column name =>WITHDRAW
	@Column(name="WITHDRAW")
	private long withdraw;
	
	//Mapping to the column name =>DEPOSIT
	@Column(name="DEPOSIT")
	private long deposit;
	
	//Mapping to the column name =>ACCOUNTNUMBER
	@Column(name="ACCOUNTNUMBER")
	private long clientaccount ;
	
	//Mapping to the column name =>EMAIL
	@Column(name="EMAIL")
	private String email ;
	
	//Mapping to the column name =>MOBILENO
	@Column(name="MOBILENO")
	private long mobileno ;
	
	//Mapping to the column name =>CLIENTADDRESS
	@Column(name="CLIENTADDRESS")
	private String clientaddress ;
	/*
	 * Non Argument Constructor
	 */
	public Client() {
		
	}
	/*
	 * Parameterized Constructor 
	 */
	
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
	
	/*
	 * Getters and Setters
	 */
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

	
	}