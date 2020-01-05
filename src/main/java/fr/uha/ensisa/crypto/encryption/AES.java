package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class AES extends AbstractEncryption{
	public AES() throws GeneralSecurityException {
        super("AES");
    }
	public byte[] createSymmetricEncryption() throws GeneralSecurityException {
		 byte[] bytes = null;
		 //création d'une clé AES
		 KeyGenerator kg = KeyGenerator.getInstance("AES");
		 kg.init(128);
		 SecretKey key = kg.generateKey();
		 //chiffrage
        this.chiffreur.init(Cipher.ENCRYPT_MODE, key);
        bytes = chiffreur.doFinal(input);
        //déchiffrage  
        this.dechiffreur.init(Cipher.DECRYPT_MODE, key);
        bytes = dechiffreur.doFinal(bytes);
        return bytes;
   }

}
