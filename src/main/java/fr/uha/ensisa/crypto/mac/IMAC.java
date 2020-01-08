package fr.uha.ensisa.crypto.mac;

import java.security.GeneralSecurityException;

public interface IMAC {

	public byte[] createMAC() throws GeneralSecurityException;

	public void setInput(byte[] input);

}
