package fr.uha.ensisa.crypto.encryption.graphics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.uha.ensisa.crypto.graphics.IDictionary;
import fr.uha.ensisa.crypto.encryption.IEncryption;

public class EncryptionDictionary implements IDictionary {
	private Map<String, IEncryption> encryptions;

	public EncryptionDictionary() {
		this.encryptions = new HashMap<String, IEncryption>();
	}

	public void add(IEncryption encryption) {
		this.encryptions.put(encryption.name(), encryption);
	}

	@Override
	public Set<String> keySet() {
		return this.encryptions.keySet();
	}

	public IEncryption get(String key) {
		return this.encryptions.get(key);
	}

}
