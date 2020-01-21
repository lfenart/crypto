package fr.uha.ensisa.crypto.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RC5_CFB_PKCS5Padding extends AbstractSymmetricEncryption{
	private static final String name = "RC5/CFB/PKCS5Padding";

    public RC5_CFB_PKCS5Padding() throws GeneralSecurityException {
        super("AES", name);
    }

    @Override
    public byte[] createEncryption() throws GeneralSecurityException {
    	 byte[] bytes = null;        
         try {
         	String initVector = "encryptionIntVec";
         	String key = "rc5EncryptionKey";
         	AlgorithmParameterSpec rcSpec = new RC5ParameterSpec(2, 12, 32, initVector.getBytes("UTF-8"));
 			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "RC5");
 			
 	        // chiffrage
 	        this.chiffreur.init(Cipher.ENCRYPT_MODE, skeySpec, rcSpec);
 	        bytes = chiffreur.doFinal(input);
 	        // déchiffrage
 	        this.dechiffreur.init(Cipher.DECRYPT_MODE, skeySpec, rcSpec);
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
