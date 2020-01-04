package fr.uha.ensisa.crypto.signature;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public abstract class AbstractSignature implements ISignature {

	protected String filePath;
	protected Signature sig;
	protected KeyGeneratorRSA keyGen;
	protected PrivateKey privateKey;

	public AbstractSignature(String algorithm) throws NoSuchAlgorithmException {
		this.keyGen = new KeyGeneratorRSA();
		this.keyGen.setKeySize(2048);
		this.privateKey = keyGen.createKey();
		this.sig = Signature.getInstance(algorithm);
		this.setInput(new byte[0]);
	}

	public void setInput(byte[] input) {
		try {
			this.sig.initSign(this.privateKey);
			this.sig.update(input);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	public byte[] createSignature() throws Exception {
		return this.sig.sign();
	}

}
