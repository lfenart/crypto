package fr.uha.ensisa.crypto.hash.time;

import java.security.DigestException;
import java.security.GeneralSecurityException;

import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.time.AbstractTimer;

/**
 * 
 * @author Lucas Fenart
 * Timer to measure Hash performances
 *
 */

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

	protected void run() throws GeneralSecurityException {
		byte[] bytes = this.hash.createHash();
		if (!this.hash.verify(bytes)) {
			throw new DigestException("Verification failed");
		}
	}
}
