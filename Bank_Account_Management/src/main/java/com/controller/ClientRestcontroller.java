package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.Client;
import com.client.ClientTransaction;
import com.clientService.ClientService;

@RestController
public class ClientRestcontroller {
	@Autowired
	private ClientService service;
	
	@GetMapping(path="/welcome", produces = "application/json")
    public String welcomeMethod() 
    {
        return "Welcome to BAnk Account Management System";
    }
	
	@PostMapping(path="/login", produces = "application/json")
    public Client validation(@RequestBody String username,String password) throws Exception {
		Client client=service.validate(username, password);
        return client;
    }
	@PostMapping(path="/allclient",  consumes = "application/json",produces = "application/json")
    public List<ClientTransaction> allTransaction(@RequestBody Client client) throws Exception {
		List<ClientTransaction> list=service.oneMonthReport(client);
        return list;
    }
	
	
}
