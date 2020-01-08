package fr.uha.ensisa.crypto.signature;

import java.security.GeneralSecurityException;

public interface ISignature {

	public byte[] createSignature() throws GeneralSecurityException;

	public void setInput(byte[] input);

	public boolean verifySignature(byte[] signature) throws GeneralSecurityException;

	public String name();

}
