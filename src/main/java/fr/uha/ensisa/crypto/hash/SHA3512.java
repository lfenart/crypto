package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA3-512 hash
 * 
 * @author Lucas Fénart
 *
 */

public class SHA3512 extends AbstractHash {

	private final static String name = "SHA3-512";

	public SHA3512() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}