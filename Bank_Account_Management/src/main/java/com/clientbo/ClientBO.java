package com.clientbo;

import com.client.Client;
import com.clientDAO.TransactionDAO;

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
