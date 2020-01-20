package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * Concrete IHash to perform SHA1 hash
 * 
 * @author Lucas Fénart
 *
 */

public class SHA extends AbstractHash {

	private final static String name = "SHA";

	public SHA() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}