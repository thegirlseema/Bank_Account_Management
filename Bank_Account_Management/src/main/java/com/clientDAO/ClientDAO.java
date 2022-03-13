package com.clientDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.client.Client;

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
	
	/*public Client find(String user){
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
	}*/
	
}