package com.bank.clientdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.Client;
/*
 * ClientRepository do the CRUD operation. 
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>
{
	public Client findByUsername(String username);
	public Client findByClientid(long clientid);
	public Client findByMobileno(long mobileno);
	public Client findByClientaccount(long clientaccount);
}