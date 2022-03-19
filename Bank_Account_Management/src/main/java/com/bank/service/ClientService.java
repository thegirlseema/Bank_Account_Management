package com.bank.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		System.out.println(e);
			return c;
		}*/
		return c;
	}
	
	@Transactional
	public List<ClientTransaction> totalTransaction(Client obj){
		long id=obj.getClientid();
		return tdao.findByClientid(id);
	}
	
	@Transactional
	public Client withdraw(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.withdraw(amount, obj);
		dao.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		//String tdate, String username, String type, long amount, long clientid
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Withdraw",amount,obj.getClientid());
		tdao.save(transobj);
		return obj1;
	}
	
	@Transactional
	public Client deposit(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.deposit(amount, obj);
		dao.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		//String tdate, String username, String type, long amount, long clientid
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Deposit",amount,obj.getClientid());
		tdao.save(transobj);
		return obj1;
	}
	
	
}