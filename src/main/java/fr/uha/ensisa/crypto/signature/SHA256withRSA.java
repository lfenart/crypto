package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA256withRSA extends AbstractSignature {

	private static final String name = "SHA256withRSA";

	public SHA256withRSA() throws NoSuchAlgorithmException {
		super(name, "RSA");

	}

	@Override
	public String name() {
		return name;
	}

}
