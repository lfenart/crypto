package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;


/**
 * 
 * Concrete IHash to perform SHA512 hash
 * @author Lucas Fénart
 *
 */

public class SHA512 extends AbstractHash {

	private final static String name = "SHA-512";

	public SHA512() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}