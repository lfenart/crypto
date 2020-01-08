package fr.uha.ensisa.crypto.signature;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import fr.uha.ensisa.crypto.keygenerator.KeyGenerator;
import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public abstract class AbstractSignature implements ISignature {

	protected String filePath;
	protected Signature sig;
	protected KeyGenerator keyGen;
	protected KeyPair keyPair;
	protected byte[] input;

	public AbstractSignature(String algorithm) throws NoSuchAlgorithmException {
		this.keyGen = new KeyGenerator(algorithm.substring(algorithm.length() - 3));
		this.keyGen.setKeySize(1024);
		this.keyPair = keyGen.createKeyPair();
		this.sig = Signature.getInstance(algorithm);
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

	public byte[] createSignature() throws GeneralSecurityException {
		this.sig.initSign(this.keyPair.getPrivate());
		this.sig.update(this.input);
		return this.sig.sign();
	}

	public boolean verifySignature(byte[] signature) throws GeneralSecurityException {
		this.sig.initVerify(this.keyPair.getPublic());
		this.sig.update(this.input);
		return this.sig.verify(signature);
	}

}
