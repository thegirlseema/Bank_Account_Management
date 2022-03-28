package com.bank.service;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.client.Client;
import com.bank.client.ClientTransaction;
import com.bank.clientbo.ClientBO;
import com.bank.clientdao.ClientRepository;
import com.bank.clientdao.TransactionRepository;
import com.bank.exception.ClientAlreadyExist;
import com.bank.exception.ClientNotFoundException;

/*
 * ClientService Class With Annotation 
 * 
 */

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	

	/* 
	 * findbyuser method is used for finding user by using username 
	 */
	
	@Transactional
	public Client findByUser(String username){
		Client clientList=clientRepository.findByUsername(username);
		 return clientList;
	}
	

	/* 
	 * newClient method is used for adding new user with proper validation  
	 */
	
	@Transactional
	public boolean newClient(Client client){
		String username=client.getUsername();
		long mobile=client.getMobileno();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date=new Date();
		String doj=formatter.format(date);
		client.setDoj(doj);
		client.setAccountbalance(1000);
		
		try {
			if(clientRepository.findByUsername(username)!=null || clientRepository.findByClientaccount(client.getClientaccount())!=null
					|| clientRepository.findByMobileno(client.getMobileno())!=null) {
				throw new ClientAlreadyExist("Username / Account Number /Mobile Number is already exist");
			}
			else {
				String ePassword=encrypt(client.getPassword());
				client.setPassword(ePassword);
				clientRepository.save(client);
				System.out.println("New Client Added Successfully");
			}
			}
			catch(Exception e)
			{
			System.out.println(e);
				return false;
			}
			return true;
	}
	
	/* 
	 * validate method is used for validation of username and password 
	 * 
	 */
	
	/* 
	 * validate method is used for validation of username and password 
	 * 
	 */
	
	@Transactional
	public Client validate(String user, String password) throws Exception {
		System.out.println("Service Class is called");
		Client c=clientRepository.findByUsername(user);
		//password encryption
		String ePassword=encrypt(password);
		System.out.println("Encrypted Password==>"+ePassword);
		try {
		if(c==null) {
			throw new ClientNotFoundException("Invalid Username");
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
			return c;
		}
		return c;
	}
	

	/* 
	 * totaltransaction method is used for fetching the transaction detail using client id 
	 * 
	 */
	
	@Transactional
	public List<ClientTransaction> totalTransaction(Client obj){
		long id=obj.getClientid();
		return transactionRepository.findByClientid(id);
	}
	

	/* 
	 * withdraw method is used for withdraw using client id and amount to be withdrawn
	 * 
	 */
	
	@Transactional
	public Client withdraw(long amount,long id)
	{
		ClientBO bo=new ClientBO();
		Client obj=clientRepository.findByClientid(id);
		Client obj1=bo.withdraw(amount, obj);
		clientRepository.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Withdraw",amount,obj.getClientid());
		transactionRepository.save(transobj);
		return obj1;
	}
	

	/* 
	 * deposit method is used for deposit using client id and amount to be deposit
	 * 
	 */
	
	@Transactional
	public Client deposit(long amount,long id)
	{
		ClientBO bo=new ClientBO();
		Client obj=clientRepository.findByClientid(id);
		Client obj1=bo.deposit(amount, obj);
		clientRepository.save(obj1);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date date=new Date();
		String sdate=formatter1.format(date);
		ClientTransaction transobj=new ClientTransaction(sdate,obj.getUsername(),"Deposit",amount,obj.getClientid());
		transactionRepository.save(transobj);
		return obj1;
	}
	/*
	 * Encryption Method
	 */
	private static final String SECRET_KEY = "my_super_secret_key";
	  private static final String SALT = "ssshhhhhhhhhhh!!!!";
	 
	  public static String encrypt(String strToEncrypt) {
	    try {
	      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	      IvParameterSpec ivspec = new IvParameterSpec(iv);
	 
	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
	      SecretKey tmp = factory.generateSecret(spec);
	      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	 
	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	      return Base64.getEncoder()
	          .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
	    } catch (Exception e) {
	      System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	  }
	  /*
	   * Decryption Method
	   */
	  public static String decrypt(String strToDecrypt) {
		    try {
		      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		      IvParameterSpec ivspec = new IvParameterSpec(iv);
		 
		      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
		      SecretKey tmp = factory.generateSecret(spec);
		      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
		 
		      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
		      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		    } catch (Exception e) {
		      System.out.println("Error while decrypting: " + e.toString());
		    }
		    return null;
		  }
	
}