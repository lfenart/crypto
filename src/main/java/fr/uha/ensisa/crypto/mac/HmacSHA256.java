package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public class HmacSHA256 extends AbstractMAC {

	public HmacSHA256() throws GeneralSecurityException {
		super("HmacSHA256");
	}

}
