package com.bank.exception;

import java.io.IOException;
/*
 * Customized Exception
 * It throw exception,If the Client is not in database exist 
 */
public class ClientNotFoundException extends Exception {
	public ClientNotFoundException(String str) {
		super(str);
		
	}
}
