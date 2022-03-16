package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.service.ClientService;

@RestController
public class ClientRestcontroller {
	@Autowired
	private ClientService service;
	
	@GetMapping(path="/welcome", produces = "application/json")
    public String welcomeMethod() 
    {
        return "Welcome to Bank Account Management System";
    }
	
	@PostMapping(path="/login", produces = "application/json")
    public Client validation(@RequestParam String username,String password) throws Exception {
		Client client=service.validate(username, password);
        return client;
    }
	
	@PostMapping(path="/registor",  consumes = "application/json",produces = "application/json")
    public String registor(@RequestBody Client client) throws Exception {
		boolean b=service.registor(client);
        if(b)
        {
        	return "Successfully registered";
        }
        return "Username is already exist";
    }
	@PostMapping(path="/report",  consumes = "application/json",produces = "application/json")
    public List<ClientTransaction> allTransaction(@RequestBody Client client) throws Exception {
		List<ClientTransaction> list=service.oneMonthReport(client);
        return list;
    }
	
	
	
}
