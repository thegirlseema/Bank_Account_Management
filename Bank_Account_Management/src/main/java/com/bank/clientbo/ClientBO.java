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
