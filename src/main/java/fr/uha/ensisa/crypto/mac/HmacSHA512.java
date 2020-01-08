package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA512 extends AbstractMAC {
	
	private static final String name = "HmacSHA512";

	public HmacSHA512() throws GeneralSecurityException {
		super(name);
	}
	
	@Override
	public String name() {
		return name;
	}

}
