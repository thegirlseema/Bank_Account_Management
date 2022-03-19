package com.bank.clientdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.Admin;

@Repository
public interface AdminDAO extends CrudRepository<Admin,String> {
	

}
