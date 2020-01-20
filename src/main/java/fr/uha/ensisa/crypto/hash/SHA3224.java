package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA3-224 hash
 * 
 * @author Lucas Fénart
 *
 */

public class SHA3224 extends AbstractHash {

	private final static String name = "SHA3-224";

	public SHA3224() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}