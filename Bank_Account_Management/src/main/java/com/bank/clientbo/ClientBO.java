package com.bank.clientbo;

import org.springframework.stereotype.Component;

import com.bank.client.Client;
import com.bank.clientdao.TransactionDAO;

@Component
public class ClientBO {
	public Client withdraw(long amount,Client obj)
	{
		long balance=obj.getAccountbalance();
		balance=balance-amount;
		obj.setAccountbalance(balance);
		obj.setWithdraw(amount);
		return obj;
	}
	public Client deposit(long amount,Client obj)
	{
		long balance=obj.getAccountbalance();
		balance=balance+amount;
		obj.setAccountbalance(balance);
		obj.setDeposit(amount);;
		return obj;
	}
}
/*
{
"clientid": 10,
"clientname": "Robert",
"username": "rob123",
"password": "1234",
"accountbalance": 6300,
"outstandingbalance": 1000,
"doj": "12/07/2021",
"withdraw": 100,
"deposit": 1000,
"clientaccount": 501234
}
*/