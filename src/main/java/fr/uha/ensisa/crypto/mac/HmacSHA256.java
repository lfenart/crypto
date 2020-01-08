package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA256 extends AbstractMAC {
	
	private static final String name = "HmacSHA256";

	public HmacSHA256() throws GeneralSecurityException {
		super("HmacSHA256");
	}
	
	@Override
	public String name() {
		return name;
	}

}
