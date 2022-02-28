package com.clientService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.client.Client;
import com.clientDAO.ClientDAO;
import com.clientNotFoundException.ClientNotFoundException;
import com.clientbo.ClientBO;

@Path("/clientService")
public class ClientService {
	@POST
	@Path("/userLogin")
	@Produces("text/plain")
	public Client validate(String user, String password) throws Exception {
		ClientDAO dao=new ClientDAO();
		Client c=dao.validate(user, password);
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		return c;
	}
	public Client withdraw(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.withdraw(amount, obj);
		return obj1;
	}
	public Client deposit(long amount,Client obj)
	{
		ClientBO bo=new ClientBO();
		Client obj1=bo.deposit(amount, obj);
		return obj1;
	}

}