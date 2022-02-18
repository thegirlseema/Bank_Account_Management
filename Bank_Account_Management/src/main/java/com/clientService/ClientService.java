package com.clientService;

import com.client.Client;
import com.clientDAO.ClientDAO;
import com.clientNotFoundException.ClientNotFoundException;


public class ClientService {

	public Client validate(String user, String password) throws Exception {
		ClientDAO dao=new ClientDAO();
		Client c=dao.validate(user, password);
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		return c;
	}
	

}