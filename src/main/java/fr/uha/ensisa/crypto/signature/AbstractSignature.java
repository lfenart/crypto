package fr.uha.ensisa.crypto.signature;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import fr.uha.ensisa.crypto.keygenerator.KeyGeneratorRSA;

public abstract class AbstractSignature implements ISignature {

	protected String filePath;
	protected Signature sig;
	protected KeyGeneratorRSA keyGen;
	protected KeyPair keyPair;
	protected byte[] input;

	public AbstractSignature(String algorithm) throws NoSuchAlgorithmException {
		this.keyGen = new KeyGeneratorRSA();
		this.keyGen.setKeySize(2048);
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
