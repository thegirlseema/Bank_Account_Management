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
		
//		String user = object.getUserName();
//		Date cDate=new Date();)
//		ClientTransaction ct=new ClientTransaction();
//		//ct.setSno(2);
//		ct.setUsername(user);
//		String dt=formatter.format(cDate);
//		try {
//			ct.setDate(formatter.parse(dt));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ct.setWithdraw(1000);
//		ct.setDeposit(0);
//		session.saveOrUpdate(ct);
		
//		Query selectQuery = (Query) session.createQuery("select obj from ClientTransaction obj where obj.username =:userName");
//		selectQuery.setParameter("userName", user);
//		List resultset = selectQuery.getResultList();
//		ClientTransaction cobj = null;
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
//		
//		System.out.println();
//		for (Object c : resultset) {
//			cobj = (ClientTransaction) c;
//			String s=cobj.getDate().toString();
//			System.out.println(s);
//			System.out.println(cobj.getDeposit()+"<-deposit-Date->"
//			+ formatter.format(cobj.getDate())+ "UName-> " + cobj.getUsername());
//		}
		
		t.commit();
		session.close();

	}

	public void deposit(Client object) {
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}
}
