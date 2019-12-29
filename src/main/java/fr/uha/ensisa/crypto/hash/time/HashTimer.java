package fr.uha.ensisa.crypto.hash.time;

import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.time.AbstractTimer;

public class HashTimer extends AbstractTimer {

	private IHash hash;
	
	public HashTimer() {
		
	}
	
	public HashTimer(IHash hash) {
		this.hash = hash;
	}
	
	public void setHash(IHash hash) {
		this.hash = hash;
	}

	protected void run() {
		this.hash.createHash();
	}
}
