package com.clientDAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

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
			System.out.println(cobj.getAccountBalance());
		}
		t.commit();
		return cobj;
	}
	
	public Client find(String user){
		Client c=new Client();
		c=null;
		SessionFactory sessionFactory=ClientDB.getSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Query selectQuery = (Query) session.createQuery("select obj from Client obj where obj.userName =:userName");
		selectQuery.setParameter("userName", user);
		 List resultset  =  selectQuery.getResultList();
		 Client c1=new Client();
		for(Object u: resultset)
        {
        	 c=(Client) u;
        	 System.out.println(c.getClientID()+c.getClientAccount());
       }
		t.commit();
 		session.close();
		return c;
	}
	
}