package com.bank.exception;
/*
 * Customized Exception
 * It throw exception,If the Client is Already exist 
 */
public class ClientAlreadyExist extends Exception{
	public ClientAlreadyExist(String str)
	{
		super(str);
	}
}
