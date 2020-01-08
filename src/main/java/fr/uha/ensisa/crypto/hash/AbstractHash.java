package fr.uha.ensisa.crypto.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * Wrapper around MessageDigest
 * @author Lucas Fénart
 *
 */

public abstract class AbstractHash implements IHash {

	protected byte[] input;
	protected MessageDigest md;
	protected byte[] hash;

	public AbstractHash(String algorithm) throws NoSuchAlgorithmException {
		this.md = MessageDigest.getInstance(algorithm);
	}

	public byte[] createHash() {
		return this.md.digest(this.input);
	}

	public void setInput(byte[] input) {
		this.input = input;
		this.hash = this.createHash();
	}

	@Override
	public boolean verify(byte[] bytes) {
		if (bytes.length != this.hash.length)
			return false;
		for (int i = 0; i < bytes.length; i++) {
			if (bytes[i] != this.hash[i])
				return false;
		}
		return true;
	}

}