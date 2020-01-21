package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.KeyPair;

import javax.crypto.Cipher;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public class RSAEncryption extends AbstractAsymmetricEncryption {

	private static final String name = "RSA";

	public RSAEncryption() throws GeneralSecurityException {
		super(name);
	}

	@Override
	public String name() {
		return name;
	}

}
