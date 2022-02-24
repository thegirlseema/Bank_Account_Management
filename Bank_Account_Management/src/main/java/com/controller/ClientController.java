package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;

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
		
		if(obj!=null && password.equals(obj.getPassword())) {
			
			System.out.println("Password-->"+obj.getPassword());
			session.setAttribute("userName", user);
			session.setAttribute("password", obj.getPassword());
			session.setAttribute("object", obj);
			response.sendRedirect("Main.html");
			
		}
		else {
			err="Invalid UserName/Password";
			request.setAttribute("loginerr", err);
			PrintWriter out = response.getWriter();
			response.sendRedirect("invaliduser.html");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("object");
		Client cobj1=(Client) obj;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body style='background-color: #4CAF50;'><center><h1>Account Details</h1><br>");
		out.print("<h4>Name : "+cobj1.getClientName()+"</h4><br>");
		out.print("<h4>User Name : "+cobj1.getUserName()+"</h4><br>");
		out.print("<h4>Account No.   : "+cobj1.getClientAccount()+"</h4><br>");
		out.print("<h4>Balance : "+cobj1.getAccountBalance()+"</h4><br>");
		out.print("<h4>Date-of-Joining: "+cobj1.getDoj()+"</h4><br></center></body>");
		//)
	}


}
