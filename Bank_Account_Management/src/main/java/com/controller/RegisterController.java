package com.controller;

/*

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.client.Client;
import com.clientDAO.ClientDAO;



@Controller
public class RegisterController {
	
	ClientDAO cl;
	// Return registration form template
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, Client client){
		modelAndView.addObject("client", client);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView,Client client, HttpServletRequest request) {
				
		// Lookup user in database by e-mail
		Client clientExists = cl.find(client.getEmail());
		
		System.out.println(clientExists);
		
		if (clientExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a Client registered with the email provided.");
			modelAndView.setViewName("register");
			
		}
		cl.save(clientExists);
		
		return modelAndView;
	}
	
	
	
}*/