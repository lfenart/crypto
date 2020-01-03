package fr.uha.ensisa.crypto.signature;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public abstract class AbstractSignature implements ISignature {

	protected String filePath;
	protected Signature sig;
	protected KeyGeneratorRSA keyGen;
	protected PrivateKey privateKey;

	public AbstractSignature(String algorithm) throws NoSuchAlgorithmException {
		keyGen = new KeyGeneratorRSA();
		keyGen.setKeySize(2048);
		privateKey = keyGen.createKey();
		this.sig = Signature.getInstance(algorithm);

	}

	public byte[] createSignature()  {
		// Update the signature to the content of the file
		try {
			this.sig.initSign(privateKey);
			BufferedInputStream file = new BufferedInputStream(new FileInputStream(filePath));
			byte[] buffer = new byte[1024];
			int n ;
			while (file.available() != 0) {
				n = file.read(buffer);
				sig.update(buffer);
			}
			file.close();
		} catch (IOException e) {
			System.err.println("Cannot read file : " + e);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		//Save the signature
		try {
			FileOutputStream file = new FileOutputStream("SignatureRSA");
			file.write(sig.sign());
			file.close();
			return sig.sign();
		}catch(Exception e) {
			
		}

		return null;

	}

	public void setFile(String file) {
		this.filePath = "resources/" + file;
	}

}
