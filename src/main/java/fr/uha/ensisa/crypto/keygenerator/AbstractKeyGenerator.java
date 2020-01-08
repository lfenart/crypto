package fr.uha.ensisa.crypto.keygenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;

public abstract class AbstractKeyGenerator implements IKeyGenerator {

	protected int size;
	protected PrivateKey privateKey;
	protected KeyPairGenerator keyPairGen;
	protected KeyPair keyPair;

	public AbstractKeyGenerator(String algorithm) throws NoSuchAlgorithmException {
		keyPairGen = KeyPairGenerator.getInstance(algorithm);
	}

	public KeyPair createKeyPair() {
		keyPairGen.initialize(this.size);
		return keyPairGen.generateKeyPair();
	}

	public void setKeySize(int size) {
		this.size = size;

	}
	
	
	

}
