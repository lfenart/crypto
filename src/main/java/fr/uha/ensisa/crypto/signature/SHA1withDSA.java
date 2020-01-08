package fr.uha.ensisa.crypto.signature;

import java.security.NoSuchAlgorithmException;

public class SHA1withDSA extends AbstractSignature {

	private static final String name = "SHA1withDSA";

	public SHA1withDSA() throws NoSuchAlgorithmException {
		super(name, "DSA");

	}

	@Override
	public String name() {
		return name;
	}

}
