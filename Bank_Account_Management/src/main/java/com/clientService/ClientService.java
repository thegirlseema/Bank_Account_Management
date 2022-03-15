package com.clientService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.Client;
import com.client.ClientTransaction;
import com.clientDAO.ClientDAO;
import com.clientDAO.TransactionDAO;
import com.clientNotFoundException.ClientNotFoundException;
import com.clientbo.ClientBO;


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
	public Client validate(String user, String password) throws Exception {
		System.out.println("Service Class is called");
		Client c=dao.findByName(user);
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		return c;
	}
	
	@Transactional
	public List<ClientTransaction> oneMonthReport(Client obj){
		String name=obj.getUsername();
		return tdao.findByName(name);
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