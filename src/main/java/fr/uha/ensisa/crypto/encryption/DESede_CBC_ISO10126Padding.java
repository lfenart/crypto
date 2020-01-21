package fr.uha.ensisa.crypto.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DESede_CBC_ISO10126Padding extends AbstractSymmetricEncryption{
	
	 private static final String name = "DESede/CBC/NoPadding";

    public DESede_CBC_ISO10126Padding() throws GeneralSecurityException {
        super("DES", name);
    }
    
    @Override
    public byte[] createEncryption() throws GeneralSecurityException {
    	 byte[] bytes = null;        
         try {
        	 String initVector = "encryptionIntVec";
          	String key = "desEncryptionKey";
  			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
  			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "DES");
  			
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
