package com.clientDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.client.Client;
import com.client.ClientTransaction;

public class TransactionDAO {
	public void withdraw(Client object)  {
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);

		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setDate(sdate);
		String user=object.getUserName();
		ct.setUsername(user);
		ct.setType("Withdraw");
		long with=object.getWithdraw();
		ct.setAmount(with);
		session.save(ct);
		
		
		t.commit();
		session.close();
		

	}
	
	public List<ClientTransaction> monthReport(Client obj){
		String user=obj.getUserName();
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = (Query) session.createQuery("select obj from ClientTransaction obj where obj.username =:userName");
		selectQuery.setParameter("userName", user);
		List<ClientTransaction> resultset = selectQuery.getResultList();
		//ClientTransaction cobj = null;
		
		System.out.println();
		for (ClientTransaction cobj : resultset) {
					
				System.out.println(cobj.getAmount()+"<-Amount\n"+
						cobj.getDate()+"<-Date\n"+cobj.getType()+"<-Type");
			
		}
		
		t.commit();
		session.close();
		return resultset;
		
	}
	public void deposit(Client object) {
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction ct=new ClientTransaction();
		ct.setDate(sdate);
		String user=object.getUserName();
		ct.setUsername(user);
		ct.setType("Deposit");
		long with=object.getDeposit();
		ct.setAmount(with);
		session.save(ct);
		
		t.commit();
		session.close();
	}
}
