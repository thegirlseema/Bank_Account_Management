package com.clientDAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.client.ClientTransaction;

@Repository
public interface TransactionDAO extends CrudRepository<ClientTransaction, Long>
{
	List<ClientTransaction> findByName(String name);

	
}