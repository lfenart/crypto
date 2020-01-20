package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA256 hash
 * 
 * @author Lucas Fénart
 * 
 */

public class SHA256 extends AbstractHash {

	private final static String name = "SHA-256";

	public SHA256() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}