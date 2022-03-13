package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.Client;
import com.client.ClientTransaction;
import com.clientService.ClientService;
/*
@WebServlet("/Report")
public class ReportController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("object");
		Client cobj1=(Client) obj;
		String str=request.getParameter("report");
		if(str.equals("Last-Transaction")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<html><body style='background-color: #4CAF50;'><center><h1>Last Transaction</h1><br>");
			out.print("<br><br><h2>Last Deposit => "+cobj1.getDeposit()+"</h2><br>");
			out.print("<br><h2>Last Withdraw => "+cobj1.getWithdraw()+"</h2><br><a href='Main.html'><button>Home</button> </a></body></center></html>");
		}
		else if(str.equals("Outstanding-Balance")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<html><body style='background-color: #4CAF50;'><center><h1>Outstanding Report</h1><br>");
			out.print("<br><h2>Current Balance => "+cobj1.getAccountbalance()+"</h2><br><br>");
			out.print("<h2>Outstanding Balance => "+cobj1.getOutstandingbalance()+"</h2><br><a href='Main.html'><button>Home</button> </a></body></center></html>");
		}
		else if(str.equals("OneMonthReport")) {
			ClientService service=new ClientService();
			List<ClientTransaction> cTrans=service.oneMonthReport(cobj1);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<html> <style>h1{color: #0ae312;}"
			+"table,th,td{ width: 40%; background-color: #e3520a; border: 1px solid black; }</style>"+
			"<body style='background-color: rgb(177, 253, 200);'><center><h1>Last One Month Report</h1><br>");
			out.print("<table><tr><td>Date and Time</td><td>Transaction</td><td>Amount</td></tr>");
			for (ClientTransaction cobj : cTrans) {
				out.print("<tr><td>"+cobj.getDate()+"</td><td>"+cobj.getType()+"</td><td>"+
						cobj.getAmount()+"</td></tr>");
			}
			out.print("</table><br><a href='Main.html'><button>Home</button> </a></center></body></html>");
		}
	}

}*/
