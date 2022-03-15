package com.clientDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.client.Client;

@Repository
public interface ClientDAO extends CrudRepository<Client, Long>
{
	Client findByName(String name);

	
}