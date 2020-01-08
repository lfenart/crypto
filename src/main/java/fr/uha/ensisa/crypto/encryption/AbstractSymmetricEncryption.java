package fr.uha.ensisa.crypto.encryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public abstract class AbstractSymmetricEncryption implements IEncryption {

	protected Cipher chiffreur;
	protected Cipher dechiffreur;
	protected byte[] input;

	@Override
	public void setInput(byte[] input) {
		this.input = input;

	}

	public AbstractSymmetricEncryption(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithm);
		this.dechiffreur = Cipher.getInstance(algorithm);

	}

}
