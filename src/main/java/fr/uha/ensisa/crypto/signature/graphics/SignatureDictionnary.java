package fr.uha.ensisa.crypto.signature.graphics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.uha.ensisa.crypto.graphics.AbstractDictionnary;
import fr.uha.ensisa.crypto.signature.ISignature;

public class SignatureDictionnary extends AbstractDictionnary {
	private Map<String, ISignature> signatures;

	public SignatureDictionnary() {
		this.signatures = new HashMap<String, ISignature>();
	}

	public void add(ISignature signature) {
		this.signatures.put(signature.name(), signature);
	}

	public Set<String> keySet() {
		return this.signatures.keySet();
	}

	public ISignature get(String key) {
		return this.signatures.get(key);
	}

}
