package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA1withDSA extends AbstractSignature {

	public SHA1withDSA() throws NoSuchAlgorithmException {
		super("SHA1withDSA", "DSA");

	}

}
