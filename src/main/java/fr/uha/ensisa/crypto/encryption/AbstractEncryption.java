package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public abstract class AbstractEncryption implements IEncryption{
	
	protected Cipher chiffreur ;
	protected Cipher dechiffreur;
	protected byte[] input;

	@Override
	public void setInput(byte[] input) {
		this.input = input;
		
	}
	
	public AbstractEncryption(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithm);
		this.dechiffreur = Cipher.getInstance(algorithm);

	}	

}
