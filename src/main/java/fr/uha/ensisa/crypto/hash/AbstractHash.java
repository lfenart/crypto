package fr.uha.ensisa.crypto.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractHash implements IHash {

	protected byte[] input;
	protected MessageDigest md;

	public AbstractHash(String algorithm) throws NoSuchAlgorithmException {
		this.md = MessageDigest.getInstance(algorithm);
	}

	public byte[] createHash() {
		return this.md.digest(this.input);
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

}