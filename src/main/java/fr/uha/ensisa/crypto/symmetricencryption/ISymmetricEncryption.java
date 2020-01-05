package fr.uha.ensisa.crypto.symmetricencryption;

import java.security.GeneralSecurityException;

public interface ISymmetricEncryption {

	public byte[] createSymmetricEncryption() throws GeneralSecurityException;

    public void setInput(byte[] input);

}
