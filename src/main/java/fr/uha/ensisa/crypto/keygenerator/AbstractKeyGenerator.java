package fr.uha.ensisa.crypto.keygenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public abstract class AbstractKeyGenerator implements IKeyGenerator {

	protected int size;
	protected PrivateKey privateKey;
	protected KeyPairGenerator keyPairGen;
	protected KeyPair keyPair;
	public AbstractKeyGenerator(String algorithm) throws NoSuchAlgorithmException{
		keyPairGen = KeyPairGenerator.getInstance(algorithm);
		//keyPairGen.initialize(size);
	}
	
	public PrivateKey createKey() {
		
		keyPairGen.initialize(size);
		KeyPair pair = keyPairGen.generateKeyPair();
		privateKey = pair.getPrivate();
		return privateKey;
		
		
	}
	
	public void setKeySize(int size) {
		this.size = size;
		
	}
}
