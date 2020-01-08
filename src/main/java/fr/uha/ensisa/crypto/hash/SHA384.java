package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA384 hash
 * @author Lucas Fénart
 *
 */

public class SHA384 extends AbstractHash {

	private final static String name = "SHA-384";

	public SHA384() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}