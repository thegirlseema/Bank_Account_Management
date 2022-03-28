package com.bank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.clientbo.ClientBO;
import com.bank.clientdao.ClientRepository;
import com.bank.clientdao.TransactionRepository;
import com.bank.exception.ClientAlreadyExist;
import com.bank.exception.ClientNotFoundException;

/*
 * ClientService Class With Annotation 
 * 
 */
@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	@Transactional
	public Client findByUser(String username){
		Client clientList=clientRepository.findByUsername(username);
		 return clientList;
	}
	@Transactional
	public boolean newClient(Client client){
		String username=client.getUsername();
		long mobile=client.getMobileno();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date=new Date();
		String doj=formatter.format(date);
		client.setDoj(doj);
		client.setAccountbalance(1000);
		
		try {
			if(clientRepository.findByUsername(username)!=null || clientRepository.findByClientaccount(client.getClientaccount())!=null
					|| clientRepository.findByMobileno(client.getMobileno())!=null) {
				throw new ClientAlreadyExist("Username / Account Number /Mobile Number is already exist");
			}
			else {
				clientRepository.save(client);
				System.out.println("New Client Added Successfully");
			}
			}
			catch(Exception e)
			{
			System.out.println(e);
				return false;
			}
			return true;
	}
	
	
	@Transactional
	public Client validate(String user, String password) throws Exception {
		System.out.println("Service Class is called");
		Client c=clientRepository.findByUsername(user);
		
		try {
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
			return c;
		}
		return c;
	}
	
	@Transactional
	public List<ClientTransaction> totalTransaction(Client obj){
		long id=obj.getClientid();
		return transactionRepository.findByClientid(id);
	}
	
	@Transactional
	public Client withdraw(long amount,long id)
	{
		ClientBO bo=new ClientBO();
		Client obj=clientRepository.findByClientid(id);
		Client obj1=bo.withdraw(amount, obj);
		clientRepository.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Withdraw",amount,obj.getClientid());
		transactionRepository.save(transobj);
		return obj1;
	}
	
	@Transactional
	public Client deposit(long amount,long id)
	{
		ClientBO bo=new ClientBO();
		Client obj=clientRepository.findByClientid(id);
		Client obj1=bo.deposit(amount, obj);
		clientRepository.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Deposit",amount,obj.getClientid());
		transactionRepository.save(transobj);
		return obj1;
	}
	
	
}