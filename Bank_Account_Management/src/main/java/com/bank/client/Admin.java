package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINDETAIL")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminid;
	// Mapping to the column name =>FIRSTNAME
	@Column(name = "FIRSTNAME")
	private String firstname;

	// Mapping to the column name =>LASTNAME
	@Column(name = "LASTNAME")
	private String lastname;

	// Mapping to the column name =>USERNAME
	@Column(name = "USERNAME")
	private String username;

	// Mapping to the column name =>PASSWORD
	@Column(name = "PASSWORD")
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(long adminid, String firstname, String lastname, String username, String password) {
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public long getAdminid() {
		return adminid;
	}

	public void setAdminid(long adminid) {
		this.adminid = adminid;
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
	
}
