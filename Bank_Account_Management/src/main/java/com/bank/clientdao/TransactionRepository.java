package com.bank.clientdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.ClientTransaction;
/*
 * TransactionRepository do the CRUD operation. 
 */
@Repository
public interface TransactionRepository extends CrudRepository<ClientTransaction, Long>
{
	List<ClientTransaction> findByUsername(String username);
	List<ClientTransaction> findByClientid(long clientid);
	
}