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
		
		if(obj!=null && password.equals(obj.getPassword())) {
			try {
	            // instantiate CookieManager
	            CookieManager manager = new CookieManager();
	            CookieHandler.setDefault(manager);
	            CookieStore cookieJar =  manager.getCookieStore();

	            // create cookie
	            HttpCookie cookie = new HttpCookie("UserName","UserNameCookieItisworking");

	            // add cookie to CookieStore for a
	            // particular URL
	            URL url = new URL("http://localhost:8084/Bank_Account_Management/home.html");
	            cookieJar.add(url.toURI(), cookie);
	            System.out.println("Added cookie using cookie handler");
	        } catch(Exception e) {
	            System.out.println("Unable to set cookie using CookieHandler");
	            e.printStackTrace();
	        }
			System.out.println("Password-->"+obj.getPassword());
			session.setAttribute("userName", user);
			session.setAttribute("password", obj.getPassword());
			session.setAttribute("object", obj);
			response.sendRedirect("home.html");
			
		}
		else {
			err="Invalid UserName/Password";
			request.setAttribute("loginerr", err);
			PrintWriter out = response.getWriter();
			response.sendRedirect("invalidlogin.html");
		}
	}

}
