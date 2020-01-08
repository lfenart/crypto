package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA224 extends AbstractMAC {
	
	private static final String name = "HmacSHA224";

	public HmacSHA224() throws GeneralSecurityException {
		super(name);
	}
	
	@Override
	public String name() {
		return name;
	}

}
