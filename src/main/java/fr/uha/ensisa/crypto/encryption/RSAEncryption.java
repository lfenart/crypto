package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.KeyPair;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;


public class RSAEncryption extends AbstractEncryption{
	public RSAEncryption() throws GeneralSecurityException {
        super("RSA");
    }

	protected KeyGeneratorRSA keyGen;
	protected KeyPair keyPair;
	
	public byte[] createSymmetricEncryption() throws GeneralSecurityException {
		 byte[] bytes = null;
		 //création d'une paire de clé RSA
		 this.keyGen = new KeyGeneratorRSA();
		 this.keyGen.setKeySize(2048);
		 this.keyPair = keyGen.createKeyPair();
		
		 //chiffrage
        this.chiffreur.init(Cipher.ENCRYPT_MODE, this.keyPair.getPublic());
        bytes = chiffreur.doFinal(input);
        
        //déchiffrage  
        this.dechiffreur.init(Cipher.DECRYPT_MODE, this.keyPair.getPrivate());
        bytes = dechiffreur.doFinal(bytes);
        
        return bytes;
   }
}
