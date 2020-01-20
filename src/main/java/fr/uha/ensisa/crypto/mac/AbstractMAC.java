package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public abstract class AbstractMAC implements IMAC {

	protected byte[] input;
	protected KeyGenerator keyGen;
	protected SecureRandom secRand;
	protected Key key;
	protected Mac mac;

	public AbstractMAC(String algorithm) throws GeneralSecurityException {
		this.keyGen = KeyGenerator.getInstance(algorithm);
		this.secRand = new SecureRandom();
		this.keyGen.init(this.secRand);
		this.key = this.keyGen.generateKey();
		this.mac = Mac.getInstance(algorithm);
	}

	public byte[] createMAC() throws GeneralSecurityException {
		this.mac.init(this.key);
		return this.mac.doFinal(this.input);
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

}
