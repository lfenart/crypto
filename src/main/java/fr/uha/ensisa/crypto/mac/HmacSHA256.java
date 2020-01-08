package fr.uha.ensisa.crypto.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacSHA256 extends AbstractMAC {

	public HmacSHA256() throws NoSuchAlgorithmException, InvalidKeyException {
		super("HmacSHA256");
		// TODO Auto-generated constructor stub
	}

}
