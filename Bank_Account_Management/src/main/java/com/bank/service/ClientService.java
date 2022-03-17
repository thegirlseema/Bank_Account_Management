package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.clientbo.ClientBO;
import com.bank.clientdao.ClientDAO;
import com.bank.clientdao.TransactionDAO;
import com.bank.notfoundexception.ClientNotFoundException;
@Service
public class ClientService {
	@Autowired
	private ClientDAO dao;
	
	@Autowired
	private TransactionDAO tdao;
	
	@Transactional
	public List<Client> allClient(){
		List<Client> clientList=new ArrayList<>();
		 dao.findAll().forEach(client -> clientList.add(client));
		 return clientList;
	}
	@Transactional
	public Client findByUser(String username){
		Client clientList=dao.findByUsername(username);
		 return clientList;
	}
	
	
	@Transactional
	public Client validate(String user, String password) throws Exception {
		System.out.println("Service Class is called");
		Client c=dao.findByUsername(user);
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		/*try {
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		}
		catch(Exception e)
		{
			return c;
		}*/
		return c;
	}
	
	@Transactional
	public List<ClientTransaction> oneMonthReport(Client obj){
		String name=obj.getUsername();
		return  tdao.findByUsername(name);
	}

	@Transactional
	public Client withdraw(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.withdraw(amount, obj);
		dao.save(obj1);
		return obj1;
	}
	
	@Transactional
	public Client deposit(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.deposit(amount, obj);
		dao.save(obj1);
		return obj1;
	}
	
	
}