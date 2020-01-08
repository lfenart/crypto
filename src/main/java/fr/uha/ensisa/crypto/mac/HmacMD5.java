package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacMD5 extends AbstractMAC {
	
	private static final String name = "HmacMD5";

	public HmacMD5() throws GeneralSecurityException {
		super(name);
	}
	
	@Override
	public String name() {
		return name;
	}

}
