package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@PostMapping(path="/login", produces = "application/json")
    public Client validation(@RequestParam String username,@RequestParam String password) throws Exception {
		System.out.println(username+" "+password);
		Client client=service.validate(username, password);
		if(client!=null && client.getPassword().equals(password) )
		{
			return client;
		}
        return client;
    }
	
	@PostMapping(path="/deposit",  consumes = "application/json",produces = "application/json")
    public  Client deposit(@RequestParam long clientid,@RequestParam long amount) throws Exception {
		Client obj=service.deposit(amount, clientid);
		return obj;
    }
	
	@PostMapping(path="/withdraw",  consumes = "application/json",produces = "application/json")
    public  Client withdraw(@RequestParam long clientid,@RequestParam long amount) throws Exception {
		Client obj=service.withdraw(amount, clientid);
		return obj;
    }
	
	@PostMapping(path="/report",  consumes = "application/json",produces = "application/json")
    public List<ClientTransaction> allTransaction(@RequestBody Client client) throws Exception {
		List<ClientTransaction> list=service.totalTransaction(client);
        return list;
    }
	@PostMapping(path="/registor",  consumes = "application/json")
    public boolean newClient(@RequestBody Client client) throws Exception {
		boolean status=service.newClient(client);
        return status;
    }
	
	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView model)  {
		model.setViewName("startpage");
		return model;
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView validation(HttpServletRequest request,ModelAndView model) throws Exception {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		Client client=service.validate(username, password);
		HttpSession session=request.getSession();
		if(client!=null && client.getPassword().equals(password) )
		{
			session.setAttribute("clientobj", client);
			model.addObject("client", client);
			model.setViewName("mainpage");
			return model;
		}
		model.setViewName("startpage");
		session.setAttribute("error", "Invalid Username/Password");
		return model; 
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public ModelAndView accountDetail(HttpServletRequest request,ModelAndView model) throws Exception {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		model.addObject("client", client);
		model.setViewName("details");
		return model;
	}
	@RequestMapping(value = "/Deposit", method = RequestMethod.POST)
	public ModelAndView depsoit(HttpServletRequest request,@RequestParam long depositAmount,ModelAndView model) throws Exception {
		//long amount = request.getParameter("depositAmount");
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		long clientid=client.getClientid();
		service.deposit(depositAmount, clientid);
		model.addObject("client", client);
		model.setViewName("mainpage");
		return model;
	}
	@RequestMapping(value = "/Withdraw", method = RequestMethod.POST)
	public ModelAndView withdraw(HttpServletRequest request,@RequestParam long withdrawAmount,ModelAndView model) throws Exception {
		//long amount = request.getParameter("depositAmount");
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		long clientid=client.getClientid();
		service.withdraw(withdrawAmount, clientid);
		model.addObject("client", client);
		model.setViewName("mainpage");
		return model;
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homepage(HttpServletRequest request,ModelAndView model) throws Exception {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		model.addObject("client", client);
		model.setViewName("mainpage");
		return model;
	}
	@RequestMapping(value = "/clientreport", method = RequestMethod.GET)
	public ModelAndView reportpage(ModelAndView model) throws Exception {
		model.setViewName("reportpage");
		return model;
	}
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ModelAndView transactionpage(ModelAndView model) throws Exception {
		model.setViewName("transaction");
		return model;
	}
	@RequestMapping(value = "/Report", method = RequestMethod.POST)
	public ModelAndView report(HttpServletRequest request,ModelAndView model) throws Exception {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		String str=request.getParameter("report");
		if(str.equals("Last-Transaction")) {
			model.addObject("client", client);
			model.setViewName("lasttransaction");
		}
		else if(str.equals("Outstanding-Balance")) {
			model.addObject("client", client);
			model.setViewName("balancereport");
		}
		else if(str.equals("TotalTransaction")) {
			List<ClientTransaction> history=service.totalTransaction(client);
			model.addObject("list", history);
			model.setViewName("monthreport");
		}
		return model;
	}
	@RequestMapping(value = "/Logout",method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,ModelAndView model)  {
		model.setViewName("startpage");
		return model;
	}
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView model)  {
		model.setViewName("register");
		return model;
	}
	
}
