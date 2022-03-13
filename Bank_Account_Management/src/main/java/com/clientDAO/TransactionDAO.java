package com.clientDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.client.Client;
import com.client.ClientTransaction;

@Repository
public class TransactionDAO {
	@Autowired
	public SessionFactory sessionFactory; 
	
	public void withdraw(Client object)  {
		/*Session session = sessionFactory.getCurrentSession();
		session.update(object);

		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setTdate(sdate);
		String user=object.getUserName();
		ct.setUsername(user);
		ct.setType("Withdraw");
		long with=object.getWithdraw();
		ct.setAmount(with);
		session.save(ct);
		
		
		session.close();*/
		

	}
	
	public List<ClientTransaction> monthReport(Client obj){
		return null;
		/*String user=obj.getUserName();
		Session session = sessionFactory.getCurrentSession();
		Query selectQuery = (Query) session.createQuery("select obj from ClientTransaction obj where obj.username =:userName");
		selectQuery.setParameter("userName", user);
		List<ClientTransaction> resultset = selectQuery.getResultList();
		//ClientTransaction cobj = null;
		
		System.out.println();
		for (ClientTransaction cobj : resultset) {
					
				System.out.println(cobj.getAmount()+"<-Amount\n"+
						cobj.getDate()+"<-Date\n"+cobj.getType()+"<-Type");
			
		}
		session.close();
		return resultset;*/
		
	}
	public void deposit(Client object) {
		/*Session session = sessionFactory.getCurrentSession();
		session.update(object);
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setTdate(sdate);
		String user=object.getUserName();
		ct.setUsername(user);
		ct.setType("Deposit");
		long with=object.getDeposit();
		ct.setAmount(with);
		session.save(ct);
		
		session.close();*/
	}
}
