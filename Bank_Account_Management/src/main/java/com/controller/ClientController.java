package com.controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.client.Client;
import com.clientService.ClientService;



@Controller
public class ClientController {
	private static final Logger logger = Logger
			.getLogger(ClientController.class);
	public ClientController() {
		System.out.println("ClientController");
		}
	
	@Autowired
	private ClientService service;
	//ClientService service=new ClientService();
	@RequestMapping(value = "/")
	public ModelAndView homePage(ModelAndView model)  {
		model.setViewName("startpage");
		return model;
	}
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView validation(HttpServletRequest request,ModelAndView model) throws Exception {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		Client client=service.validate(username, password);
		model.addObject("client", client);
		model.setViewName("mainpage");
		return model;
	}
	
}
