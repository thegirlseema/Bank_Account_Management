package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * ClientTransaction Entity Class With Annotation 
 * To Define The Table Structure Of ClientTransaction Database table
 */
@Entity
@Table(name = "TRANSACTIONDETAILS")
public class ClientTransaction{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tid;
	
	//Mapping to the column name =>TDATE
	@Column(name="TDATE")
	private String tdate;
	
	//Mapping to the column name =>USERNAME
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="ACCOUNTNO")
	private long accountno;
	
	//Mapping to the column name =>AMOUNT
	@Column(name="AMOUNT")
	private long amount;
	
	//Mapping to the column name =>CLIENTID
	@Column(name="CLIENTID")
	private long clientid;
	
	/*
	 * Non Argument Constructor
	 */
	public ClientTransaction() {
		
	}
	
	/*
	 * Parameterized Constructor 
	 */
	public ClientTransaction(String tdate, String username,String type,long accountno, long amount, long clientid) {
		
		this.tdate = tdate;
		this.username = username;
		this.type=type;
		this.accountno=accountno;
		this.amount = amount;
		this.clientid = clientid;
	}
	/*
	 * Getters and setters
	 */
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getClientid() {
		return clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}
	
	
}
