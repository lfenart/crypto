package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RC4 extends AbstractSymmetricEncryption {

	private static final String name = "RC4";

	public RC4() throws GeneralSecurityException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}
