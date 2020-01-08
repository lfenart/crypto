package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA256withRSA extends AbstractSignature {

	public SHA256withRSA() throws NoSuchAlgorithmException {
		super("SHA256withRSA", "RSA");

	}

}
