package com.bank.clientdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.Client;

@Repository
public interface ClientDAO extends CrudRepository<Client, Long>
{
	public Client findByUsername(String username);

	
}