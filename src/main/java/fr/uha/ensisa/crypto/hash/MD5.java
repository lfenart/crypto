package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class MD5 extends AbstractHash {

	private final static String name = "MD5";

	public MD5() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}