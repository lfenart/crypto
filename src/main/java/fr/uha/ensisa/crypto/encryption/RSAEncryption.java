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

	protected KeyGeneratorRSA keyGen;
	protected KeyPair keyPair;

	public byte[] createEncryption() throws GeneralSecurityException {
		byte[] bytes = null;
		// création d'une paire de clé RSA
		this.keyGen = new KeyGeneratorRSA();
		this.keyGen.setKeySize(2048);
		this.keyPair = keyGen.createKeyPair();

		// chiffrage
		this.chiffreur.init(Cipher.ENCRYPT_MODE, this.keyPair.getPublic());
		bytes = chiffreur.doFinal(input);

		// déchiffrage
		this.dechiffreur.init(Cipher.DECRYPT_MODE, this.keyPair.getPrivate());
		bytes = dechiffreur.doFinal(bytes);

		return bytes;
	}

	@Override
	public String name() {
		return name;
	}

}
