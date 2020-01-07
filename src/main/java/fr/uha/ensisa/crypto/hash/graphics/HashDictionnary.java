package fr.uha.ensisa.crypto.hash.graphics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.uha.ensisa.crypto.graphics.AbstractDictionnary;
import fr.uha.ensisa.crypto.hash.IHash;

public class HashDictionnary extends AbstractDictionnary {
	private Map<String, IHash> hashs;

	public HashDictionnary() {
		this.hashs = new HashMap<String, IHash>();
	}

	public void add(IHash hash) {
		this.hashs.put(hash.name(), hash);
	}

	public Set<String> keySet() {
		return this.hashs.keySet();
	}

	public IHash get(String key) {
		return this.hashs.get(key);
	}

}
