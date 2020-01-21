package fr.uha.ensisa.crypto.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_CFB8_NoPadding extends AbstractSymmetricEncryption{
	private static final String name = "AES/CFB8/NoPadding";

    public AES_CFB8_NoPadding() throws GeneralSecurityException {
        super("AES", name);
    }

    @Override
    public byte[] createEncryption() throws GeneralSecurityException {
    	 byte[] bytes = null;        
         try {
         	String initVector = "encryptionIntVec";
         	String key = "aesEncryptionKey";
 			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
 			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
 			
 	        // chiffrage
 	        this.chiffreur.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
 	        bytes = chiffreur.doFinal(input);
 	        // déchiffrage
 	        this.dechiffreur.init(Cipher.DECRYPT_MODE, skeySpec, iv);
 	        bytes = dechiffreur.doFinal(bytes);
         } catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
         return bytes;
	}
    
    @Override
    public String name() {
        return name;
    }
}
