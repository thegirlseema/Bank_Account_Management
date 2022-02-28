package com.client;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION2")
public class ClientTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SNO")
	private long sno;
	
	@Column(name="TDATE")
	private Date date;
	
	@Column(name="USERNAME")
	private String username;
	
	
	@Column(name="WITHDRAW")
	private long withdraw;
	
	@Column(name="DEPOSIT")
	private long deposit;
	
	public long getSno() {
		return sno;
	}
	public void setSno(long sno) {
		this.sno = sno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

}
