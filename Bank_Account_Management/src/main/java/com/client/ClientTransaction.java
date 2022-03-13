package com.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONDET")
public class ClientTransaction implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private long sno;

	@Column(name="TDATE")
	private String tdate;

	@Column(name="USERNAME")
	private String username;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="AMOUNT")
	private long amount;
	
	public ClientTransaction(long sno, String tdate, String username, String type, long amount) {
		super();
		this.sno = sno;
		this.tdate = tdate;
		this.username = username;
		this.type = type;
		this.amount = amount;
	}

	
	public ClientTransaction() {
	}


	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
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

	

}
