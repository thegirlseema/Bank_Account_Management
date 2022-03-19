package com.bank.clientdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.ClientTransaction;

@Repository
public interface TransactionDAO extends CrudRepository<ClientTransaction, Long>
{
	List<ClientTransaction> findByUsername(String username);
	List<ClientTransaction> findByClientid(long clientid);
	
}