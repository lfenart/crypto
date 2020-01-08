package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA384 extends AbstractMAC {
	
	private static final String name = "HmacSHA384";

	public HmacSHA384() throws GeneralSecurityException {
		super(name);
	}
	
	@Override
	public String name() {
		return name;
	}

}
