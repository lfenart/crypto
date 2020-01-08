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
	public byte[] createEncryption() throws GeneralSecurityException {
		byte[] bytes = null;
		// création d'une clé RC4
		KeyGenerator kg = KeyGenerator.getInstance("RC4");
		kg.init(128);
		SecretKey key = kg.generateKey();
		// chiffrage
		this.chiffreur.init(Cipher.ENCRYPT_MODE, key);
		bytes = chiffreur.doFinal(input);
		// déchiffrage
		this.dechiffreur.init(Cipher.DECRYPT_MODE, key);
		bytes = dechiffreur.doFinal(bytes);
		return bytes;
	}

	@Override
	public String name() {
		return name;
	}

}
