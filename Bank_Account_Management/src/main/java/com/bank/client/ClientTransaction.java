package com.bank.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONDET")
public class ClientTransaction{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tid;

	@Column(name="TDATE")
	private String tdate;

	@Column(name="USERNAME")
	private String username;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="AMOUNT")
	private long amount;
	
	@Column(name="CLIENTID")
	private long clientid;

	public ClientTransaction(long tid, String tdate, String username, String type, long amount, long clientid) {
		super();
		this.tid = tid;
		this.tdate = tdate;
		this.username = username;
		this.type = type;
		this.amount = amount;
		this.clientid = clientid;
	}

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
