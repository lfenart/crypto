package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA512withRSA extends AbstractSignature {

	private static final String name = "SHA512withRSA";

	public SHA512withRSA() throws NoSuchAlgorithmException {
		super(name, "RSA");

	}

	@Override
	public String name() {
		return name;
	}

}