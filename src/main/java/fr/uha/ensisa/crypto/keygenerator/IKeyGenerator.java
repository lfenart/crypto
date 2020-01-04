package fr.uha.ensisa.crypto.keygenerator;

import java.security.KeyPair;

public interface IKeyGenerator {

	public void setKeySize(int size);

	public KeyPair createKeyPair();
}
