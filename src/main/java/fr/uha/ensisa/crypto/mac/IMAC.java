package fr.uha.ensisa.crypto.mac;

import java.security.InvalidKeyException;

public interface IMAC {

	public byte[] createMAC();
	public void setMessage(String message);

}
