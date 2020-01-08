package fr.uha.ensisa.crypto.mac.graphics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.uha.ensisa.crypto.graphics.AbstractDictionnary;
import fr.uha.ensisa.crypto.mac.IMAC;

public class MacDictionnary extends AbstractDictionnary {
	private Map<String, IMAC> macs;

	public MacDictionnary() {
		this.macs = new HashMap<String, IMAC>();
	}

	public void add(IMAC mac) {
		this.macs.put(mac.name(), mac);
	}

	public Set<String> keySet() {
		return this.macs.keySet();
	}

	public IMAC get(String key) {
		return this.macs.get(key);
	}

}
