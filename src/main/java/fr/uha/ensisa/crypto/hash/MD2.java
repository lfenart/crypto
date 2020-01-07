package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class MD2 extends AbstractHash {

	private final static String name = "MD2";

	public MD2() throws NoSuchAlgorithmException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}