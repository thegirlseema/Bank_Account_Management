package com.clientService;

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
	
	@Transactional
	public Client validate(String user, String password) throws Exception {
		System.out.println("Service Class is called");
		Client c=dao.validate(user, password);
		//Client c=new Client(11,"Robert",user,password,5000,1000,"12-09-2021",1000,500,50101);
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		return c;
	}
	
	@Transactional
	public Client withdraw(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.withdraw(amount, obj);
		return obj1;
	}
	
	@Transactional
	public Client deposit(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.deposit(amount, obj);
		return obj1;
	}
	
	@Transactional
	public List<ClientTransaction> oneMonthReport(Client obj){
		TransactionDAO dao=new TransactionDAO();
		return dao.monthReport(obj);
	}

}