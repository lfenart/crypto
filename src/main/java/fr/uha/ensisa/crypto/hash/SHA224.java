package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA224 hash
 * 
 * @author Lucas Fénart
 *
 */

public class SHA224 extends AbstractHash {

	private final static String name = "SHA-224";

	public SHA224() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}