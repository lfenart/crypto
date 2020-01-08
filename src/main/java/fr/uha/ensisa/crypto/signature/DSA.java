package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class DSA extends AbstractSignature {

	public DSA() throws NoSuchAlgorithmException {
		super("SHA1withDSA","DSA");

	}

}
