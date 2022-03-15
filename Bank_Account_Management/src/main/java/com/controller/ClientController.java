package com.controller;
/*
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.client.Client;
import com.client.ClientTransaction;
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
		HttpSession session=request.getSession();
		session.setAttribute("clientobj", client);
		model.addObject("client", client);
		model.setViewName("mainpage");
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
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView report(HttpServletRequest request,ModelAndView model) throws Exception {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("clientobj");
		Client client=(Client) obj;
		String str=request.getParameter("report");
		if(str.equals("Last-Transaction")) {
			model.addObject("client", client);
			model.setViewName("mainpage");
		}
		else if(str.equals("Outstanding-Balance")) {
			model.addObject("client", client);
			model.setViewName("mainpage");
		}
		else if(str.equals("OneMonthReport")) {
			List<ClientTransaction> history=service.oneMonthReport(client);
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
	
}
*/