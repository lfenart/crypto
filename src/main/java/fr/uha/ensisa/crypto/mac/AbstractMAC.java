package fr.uha.ensisa.crypto.mac;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;


public abstract class AbstractMAC implements IMAC {
	
	
	protected String message;
	protected byte[] bytes;
	protected KeyGenerator keyGen;
	protected SecureRandom secRand;
	protected Key key;
	protected Mac mac;
	
	public AbstractMAC(String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
		this.keyGen = KeyGenerator.getInstance("DES");
		this.secRand = new SecureRandom();
		this.keyGen.init(this.secRand);
		this.key = this.keyGen.generateKey();	
		this.mac = Mac.getInstance(algorithm);
	    
		
	}

	

	public byte[] createMAC()  {
		try {
			this.mac.init(this.key);
		} catch (InvalidKeyException e) {
			
			e.printStackTrace();
		}
		this.bytes = message.getBytes();
		return this.mac.doFinal(bytes);
	}
	
	public void setMessage(String message) {
		this.message = message;
		
	}
	
	

}
