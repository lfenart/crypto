package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA3-256 hash
 * 
 * @author Lucas Fénart
 * 
 */

public class SHA3256 extends AbstractHash {

	private final static String name = "SHA3-256";

	public SHA3256() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}