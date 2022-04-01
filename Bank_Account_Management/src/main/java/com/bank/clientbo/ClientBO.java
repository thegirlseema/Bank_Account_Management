package com.bank.clientbo;

import org.springframework.stereotype.Component;

import com.bank.client.Client;
import com.bank.clientdao.TransactionRepository;
/*
 * ClientBO Class do the logic functionality
 */
@Component
public class ClientBO {
	//Changing the current balance by subtraction with withdraw amount
	/*public Client withdraw(long amount,Client obj)
	{
		long balance=obj.getAccountbalance();
		balance=balance-amount;
		obj.setAccountbalance(balance);
		obj.setWithdraw(amount);
		return obj;
	}*/
	//Changing the current balance by adding with deposit amount
	public Client sender(long amount,Client obj)
	{
		long balance=obj.getAccountbalance();
		balance=balance-amount;
		obj.setAccountbalance(balance);
		obj.setWithdraw(amount);
		return obj;
	}
	public Client reciver(long amount,Client obj)
	{
		long balance=obj.getAccountbalance();
		balance=balance+amount;
		obj.setAccountbalance(balance);
		obj.setDeposit(amount);;
		return obj;
	}
}
