package com.bank.clientdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bank.client.Admin;

/*
 * ClientRepository do the CRUD operation. 
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{
	public Admin findByUsername(String username);
	
}
