package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.Client;
import com.clientService.ClientService;

@WebServlet("/WithdrawController")
public class WithdrawController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long amount=Long.parseLong(request.getParameter("withdrawAmount"));
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("object");
		Client cobj1=(Client) obj;
		if(amount<cobj1.getAccountBalance())
		{
		ClientService service=new ClientService();
		Client cobj2=service.withdraw(amount, cobj1);
		session.setAttribute("object", cobj2);
		response.sendRedirect("Main.html");
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<center><h1>Withdraw Failed</h1><br><h2>"
					+ "Withdraw amount is greater than Account Balance</h2>"
					+ "Account Balance=>"+cobj1.getAccountBalance()+"</center>");
		}
	}

}
