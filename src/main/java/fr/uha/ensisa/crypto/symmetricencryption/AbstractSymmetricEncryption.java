package fr.uha.ensisa.crypto.symmetricencryption;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public abstract class AbstractSymmetricEncryption implements ISymmetricEncryption{
	
	private Cipher chiffreur ;
	private Cipher dechiffreur;
	private byte[] input;
	private KeyGenerator kg;

	@Override
	public void setInput(byte[] input) {
		this.input = input;
		
	}
	
	public AbstractSymmetricEncryption(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.chiffreur = Cipher.getInstance(algorithm);
		this.dechiffreur = Cipher.getInstance(algorithm);
		this.kg = KeyGenerator.getInstance(algorithm);

	}
	
	public byte[] createSymmetricEncryption() throws GeneralSecurityException {
		 byte[] bytes = null;
		 //création d'une clé AES
		 this.kg.init(128);
		 SecretKey key = this.kg.generateKey();
		 //chiffrage
         this.chiffreur.init(Cipher.ENCRYPT_MODE, key);
         bytes = chiffreur.doFinal(input);
         //déchiffrage  
         this.dechiffreur.init(Cipher.DECRYPT_MODE, key);
         bytes = dechiffreur.doFinal(bytes);
         return bytes;
    }

}
