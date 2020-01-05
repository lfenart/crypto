package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

public interface IEncryption {

	public byte[] createSymmetricEncryption() throws GeneralSecurityException;

    public void setInput(byte[] input);

}
