package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public abstract class AbstractAsymmetricEncryption implements IEncryption {

	protected Cipher chiffreur;
	protected Cipher dechiffreur;
	protected byte[] input;
	protected KeyGeneratorRSA keyGen;
	protected KeyPair keyPair;

	@Override
	public void setInput(byte[] input) {
		this.input = input;

	}

	public AbstractAsymmetricEncryption(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithm);
		this.dechiffreur = Cipher.getInstance(algorithm);
		
		// création d'une paire de clé RSA
		this.keyGen = new KeyGeneratorRSA();
		this.keyGen.setKeySize(2048);
		this.keyPair = keyGen.createKeyPair();
	}
	
	public AbstractAsymmetricEncryption(String algorithm, String algorithmmode) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithmmode);
		this.dechiffreur = Cipher.getInstance(algorithmmode);
		
		// création d'une paire de clé RSA
		this.keyGen = new KeyGeneratorRSA();
		this.keyGen.setKeySize(2048);
		this.keyPair = keyGen.createKeyPair();
	}
	
	public byte[] createEncryption() throws GeneralSecurityException {
		byte[] bytes = null;
		
		// chiffrage
		this.chiffreur.init(Cipher.ENCRYPT_MODE, this.keyPair.getPublic());
		bytes = chiffreur.doFinal(input);

		// déchiffrage
		this.dechiffreur.init(Cipher.DECRYPT_MODE, this.keyPair.getPrivate());
		bytes = dechiffreur.doFinal(bytes);

		return bytes;
	}

}
