package fr.uha.ensisa.crypto.encryption.time;

import java.security.GeneralSecurityException;

import fr.uha.ensisa.crypto.encryption.IEncryption;
import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.time.AbstractTimer;

public class EncryptionTimer extends AbstractTimer {

	private IEncryption symmetric;
	
	public EncryptionTimer() {
		
	}
	
	public EncryptionTimer(IEncryption symmetric) {
		this.symmetric = symmetric;
	}
	
	public void setSymmetric(IEncryption symmetric) {
		this.symmetric = symmetric;
	}

	protected void run() throws GeneralSecurityException {
		this.symmetric.createEncryption();
	}

}
