package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RC5 extends AbstractSymmetricEncryption {

	private static final String name = "RC5";

	public RC5() throws GeneralSecurityException {
		super("RC5/CFB/PKCS5Padding");
	}/*
		 * public byte[] createEncryption() throws GeneralSecurityException { byte[]
		 * bytes = null; SecretKeySpec key4 = new SecretKeySpec(km, "RC5");
		 * 
		 * AlgorithmParameterSpec rcSpec = new RC5ParameterSpec(2, 12, 32, iv);
		 * //création d'une clé RC5 KeyGenerator kg = KeyGenerator.getInstance("AES");
		 * kg.init(128); SecretKey key = kg.generateKey(); //chiffrage
		 * this.chiffreur.init(Cipher.ENCRYPT_MODE, key); bytes =
		 * chiffreur.doFinal(input); //déchiffrage
		 * this.dechiffreur.init(Cipher.DECRYPT_MODE, key); bytes =
		 * dechiffreur.doFinal(bytes); return bytes; }
		 */

	public byte[] createEncryption() throws GeneralSecurityException {
		return null;
	}

	@Override
	public String name() {
		return name;
	}

}
