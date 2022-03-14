package com.clientDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.client.Client;
import com.client.ClientTransaction;

@Repository
public class ClientDAO 
{
	@Autowired
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Client validate(String user, String password)
    {
		Session session = sessionFactory.getCurrentSession();
		Query selectQuery = (Query) session.createQuery("select obj from Client obj where obj.username =:un");
		selectQuery.setParameter("un", user);
		List<Client> resultset  =  selectQuery.list();
		Client cobj = null;
		for(Client c: resultset)
		{
			cobj=c;
			
		}
		return cobj;
	}
	
}