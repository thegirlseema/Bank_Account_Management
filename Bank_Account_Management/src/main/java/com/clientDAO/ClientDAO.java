package com.clientDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.client.Client;

public class ClientDAO 
{
	
	public Client validate(String user, String password)
    {
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = (Query) session.createQuery("select obj from Client obj where obj.userName =:userName");
		selectQuery.setParameter("userName", user);
		List<Client> resultset  =  selectQuery.getResultList();
		Client cobj = null;
		for(Client c: resultset)
		{
			cobj=c;
		}
		t.commit();
		return cobj;
	}
	
	public Client find(String accountNumber){
		Client c=new Client();
		c=null;
		Session session =ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = (Query) session.createQuery("select obj from Client obj where obj.accountNumber =:accountNumber");
		selectQuery.setParameter("accountNumber", accountNumber);
		 Collection resultset  =  selectQuery.list();
		 Client c1=new Client();
		for(Object u: resultset)
        {
        	 c=(Client) u;
        	 c1.setClientID(c.getClientID());
        	 c1.setClientAccount(c.getClientAccount());
        	 c1.setClientName(c.getClientName());
       }
		t.commit();
 		session.close();
		return c1;
    	
	}
	
}