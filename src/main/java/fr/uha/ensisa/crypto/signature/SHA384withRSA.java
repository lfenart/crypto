package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA384withRSA extends AbstractSignature {

	private static final String name = "SHA384withRSA";

	public SHA384withRSA() throws NoSuchAlgorithmException {
		super(name, "RSA");

	}

	@Override
	public String name() {
		return name;
	}

}
