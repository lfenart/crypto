package fr.uha.ensisa.crypto.keygenerator;

import java.security.PrivateKey;

public interface IKeyGenerator {

	public PrivateKey createKey();

	public void setKeySize(int size);

}
