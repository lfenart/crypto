package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public abstract class AbstractSymmetricEncryption implements IEncryption {

	protected Cipher chiffreur;
	protected Cipher dechiffreur;
	protected byte[] input;
	protected KeyGenerator kg;
	protected SecretKey key;

	@Override
	public void setInput(byte[] input) {
		this.input = input;

	}

	public AbstractSymmetricEncryption(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithm);
		this.dechiffreur = Cipher.getInstance(algorithm);
		// création d'une clé AES
        this.kg = KeyGenerator.getInstance(algorithm);
        //this.kg.init(128);
        this.key = kg.generateKey();
	}

	public AbstractSymmetricEncryption(String algorithm, String algorithmmode) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithmmode);
		this.dechiffreur = Cipher.getInstance(algorithmmode);
		// création d'une clé AES
        this.kg = KeyGenerator.getInstance(algorithm);
        //this.kg.init(128);
        this.key = kg.generateKey();
	}
	
	public byte[] createEncryption() throws GeneralSecurityException {
        byte[] bytes = null;
        
        // chiffrage
        this.chiffreur.init(Cipher.ENCRYPT_MODE, key);
        bytes = chiffreur.doFinal(input);
        // déchiffrage
        this.dechiffreur.init(Cipher.DECRYPT_MODE, key);
        bytes = dechiffreur.doFinal(bytes);
        
        return bytes;
	}

}
