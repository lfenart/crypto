package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA3-384 hash
 * 
 * @author Lucas Fénart
 *
 */

public class SHA3384 extends AbstractHash {

	private final static String name = "SHA3-384";

	public SHA3384() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}