package fr.uha.ensisa.crypto.signature;

import java.security.GeneralSecurityException;

//import java.security.Signature;

public interface ISignature {

	public byte[] createSignature() throws GeneralSecurityException;

	public void setInput(byte[] input);

	public boolean verifySignature(byte[] signature) throws GeneralSecurityException;

}
