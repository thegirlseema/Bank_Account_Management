package com.clientDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.client.Client;
import com.client.ClientTransaction;

@Repository
public class TransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void withdraw(Client object)  {
		/*Session session = sessionFactory.getCurrentSession();
		session.update(object);

		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setTdate(sdate);
		String user=object.getUsername();
		ct.setUsername(user);
		ct.setType("Withdraw");
		long with=object.getWithdraw();
		ct.setAmount(with);
		session.save(ct);
		*/

	}
	
	@SuppressWarnings("unchecked")
	public List<ClientTransaction> monthReport(Client obj){
		Session session = sessionFactory.openSession();
		String user=obj.getUsername();
		Query selectQuery = (Query) session.createQuery("select obj from ClientTransaction obj where obj.username =:userName");
		selectQuery.setParameter("userName", user);
		List<ClientTransaction> resultset = selectQuery.list();
		return resultset;
		
	}
	public void deposit(Client object) {
		/*Session session = sessionFactory.getCurrentSession();
		session.update(object);
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setTdate(sdate);
		String user=object.getUsername();
		ct.setUsername(user);
		ct.setType("Deposit");
		long with=object.getDeposit();
		ct.setAmount(with);
		session.save(ct);*/
	}
}
