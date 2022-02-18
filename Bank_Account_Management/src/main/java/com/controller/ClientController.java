package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.Client;
import com.clientService.ClientService;

@WebServlet("/Login")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String err="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		ClientService dao=new ClientService();
		Client obj = null;
		try {
			obj=dao.validate(user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(password.equals(obj.getPassword())) {
			
			session.setAttribute("userName", user);
			session.setAttribute("String", obj.getPassword());
			response.sendRedirect("login.html");
			
		}
		else {
			err="Invalid UserName/Password";
			request.setAttribute("loginerr", err);
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
