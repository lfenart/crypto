package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class RSA  extends AbstractSignature {

	public RSA() throws NoSuchAlgorithmException {
		super("SHA256withRSA");
		
	}

	
}
