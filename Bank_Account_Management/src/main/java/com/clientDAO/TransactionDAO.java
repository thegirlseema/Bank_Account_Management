package com.clientDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.client.Client;

public class TransactionDAO {
	public void withdraw(Client object){
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
	    t.commit();
		session.close();
	}
	public void deposit(Client object){
		Session session = ClientDB.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
	    t.commit();
		session.close();
	}
}
