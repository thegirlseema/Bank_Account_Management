package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.service.ClientService;

@RestController
@RequestMapping(path = "/Banking_System")
public class ClientRestcontroller {
	@Autowired
	private ClientService service;
	
	
	@GetMapping(path="/welcome", produces = "application/json")
    public String welcomeMethod() 
    {
        return "Welcome to Bank Account Management System";
    }
	
	@GetMapping(path="/finduser", produces = "application/json")
    public Client findUser(@RequestParam String username) 
    {
       return service.findByUser(username);
    }
	
	@PostMapping(path="/login", produces = "application/json")
    public String validation(@RequestParam String username,@RequestParam String password) throws Exception {
		System.out.println(username+" "+password);
		Client client=service.validate(username, password);
		if(client!=null && client.getPassword().equals(password) )
		{
			return client.toString();
		}
        return "Invalid Username/Password";
    }
	
	@PostMapping(path="/deposit",  consumes = "application/json",produces = "application/json")
    public  Client deposit(@RequestBody Client client,@RequestParam long amount) throws Exception {
		Client obj=service.deposit(amount, client);
		return obj;
    }
	
	@PostMapping(path="/withdraw",  consumes = "application/json",produces = "application/json")
    public  Client withdraw(@RequestBody Client client,@RequestParam long amount) throws Exception {
		Client obj=service.withdraw(amount, client);
		return obj;
    }
	

	@GetMapping(path="/allclient", produces = "application/json")
    public List<Client> allClient() 
    {
       return service.allClient();
    }
	
	@PostMapping(path="/report",  consumes = "application/json",produces = "application/json")
    public List<ClientTransaction> allTransaction(@RequestBody Client client) throws Exception {
		List<ClientTransaction> list=service.oneMonthReport(client);
        return list;
    }
	
	
}
