package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA1 extends AbstractMAC {
	
	private static final String name = "HmacSHA1";

	public HmacSHA1() throws GeneralSecurityException {
		super(name);
	}
	
	@Override
	public String name() {
		return name;
	}

}
