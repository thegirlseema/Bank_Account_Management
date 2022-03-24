package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.service.ClientService;
/*
 *Rest Controller Class
 *Register New Client 
 *Login with User name and password
 *Deposit and Withdraw
 *View Total Transaction
 */
@RestController
@CrossOrigin(origins = "http://localhost:4205")
@RequestMapping(path = "/Banking_System")
public class ClientRestcontroller {
	@Autowired
	private ClientService service;
	
	
	@GetMapping(path="/welcome", produces = "application/json")
    public String welcomeMethod() 
    {
        return "Welcome to Bank Account Management System";
    }
	/*
	 * Login with User-name and Password
	 */
	
	@PostMapping(path="/login", produces = "application/json")
    public Client validation(@RequestParam String username,@RequestParam String password) throws Exception {
		System.out.println(username+" "+password);
		Client client=service.validate(username, password);
		if(client!=null && client.getPassword().equals(password) )
		{
			return client;
		}
        return null;
    }
	/*
	 * Deposit the Amount with client-id
	 */
	@PostMapping(path="/deposit/{clientid}/{amount}",  consumes = "application/json",produces = "application/json")
    public  Client deposit(@PathVariable long clientid,@PathVariable long amount) throws Exception {
		System.out.println("Deposit class is called");
		Client obj=service.deposit(amount, clientid);
		return obj;
    }
	/*
	 * Withdraw the Amount with client-id
	 */
	@PostMapping(path="/withdraw/{clientid}/{amount}",  consumes = "application/json",produces = "application/json")
    public  Client withdraw(@PathVariable long clientid,@PathVariable long amount) throws Exception {
		System.out.println("Withdraw class is called");
		Client obj=service.withdraw(amount, clientid);
		return obj;
    }
	
	/*
	 * It gives the total transaction of particular client
	 */
	@PostMapping(path="/report",  consumes = "application/json",produces = "application/json")
    public List<ClientTransaction> allTransaction(@RequestBody Client client) throws Exception {
		
		List<ClientTransaction> list=service.totalTransaction(client);
        return list;
    }
	/*
	 * Register the new client 
	 */
	@PostMapping(path="/registor",  consumes = "application/json")
    public boolean newClient(@RequestBody Client client) throws Exception {
		boolean status=service.newClient(client);
        return status;
    }
	
	
	
}
