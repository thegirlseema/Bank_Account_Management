package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.client.Admin;
import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.service.ClientService;
/*
 *Rest Controller Class
 *URLs are mapped for Different operations
 */
@RestController
@CrossOrigin(origins = "http://localhost:4205")
@RequestMapping(path = "/Banking_System")
public class ClientRestcontroller {
	@Autowired
	private ClientService service;
	

	@GetMapping(path="/allClient", produces = "application/json")
    public List<Client>  findAll() 
    {
        return service.allClient();
    }
	
	/*
	 * Login with User-name and Password
	 */
	@PostMapping(path="/login", produces = "application/json")
    public Client validation(@RequestParam String username,@RequestParam String password) throws Exception {
		System.out.println(username+" "+password);
		Client client=service.validate(username, password);
		if(client!=null && service.decrypt(client.getPassword()).equals(password) )
		{
			return client;
		}
        return null;
    }
	
	@GetMapping(value = "/checkclient/{accno}")
	public boolean checkClient(@PathVariable int accno) throws Exception {
		System.out.println("Accno==>"+accno);
		return service.checkClient(accno);
	}
	
	
	@PostMapping(path="/validatelogin", produces = "application/json")
    public Client loginValidation(@RequestParam String username,@RequestParam String password) throws Exception {
		System.out.println(username+" "+password);
		Client sclient=service.validate("rob123", password);
		Client client=service.validate(username, password);
		if(client!=null && service.decrypt(client.getPassword()).equals(password) )
		{
			System.out.println("<---This is client account--->");
			client.setFirstname("client");
			return client;
		}
		Admin admin=service.adminValidate(username,password); 
		if(admin!=null && admin.getPassword().equals(password))
		{
			System.out.println("<---This is admin account--->");
			sclient.setClientid(admin.getAdminid());
			sclient.setFirstname("admin");
			return sclient;
		}
		sclient.setFirstname("null");
        return sclient;
    }
	/*
	 * Deposit the Amount with client-id
	 */
	@PostMapping(path="/transfer/{clientid}/{amount}/{accno}",  consumes = "application/json",produces = "application/json")
    public  Client deposit(@PathVariable long clientid,@PathVariable long amount,@PathVariable long accno) throws Exception {
		System.out.println("Deposit class is called");
		Client obj=service.deposit(amount, clientid,accno);
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
	
	@DeleteMapping(value = "/deleteclient/{accno}")
	public boolean deleteClient(@PathVariable int accno) {
		
		return service.deleteClient(accno);
	}
	
}
