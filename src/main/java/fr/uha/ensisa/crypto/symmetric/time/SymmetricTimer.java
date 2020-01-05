package fr.uha.ensisa.crypto.symmetric.time;

import java.security.GeneralSecurityException;

import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.symmetricencryption.ISymmetricEncryption;
import fr.uha.ensisa.crypto.time.AbstractTimer;

public class SymmetricTimer extends AbstractTimer {

	private ISymmetricEncryption symmetric;
	
	public SymmetricTimer() {
		
	}
	
	public SymmetricTimer(ISymmetricEncryption symmetric) {
		this.symmetric = symmetric;
	}
	
	public void setSymmetric(ISymmetricEncryption symmetric) {
		this.symmetric = symmetric;
	}

	protected void run() throws GeneralSecurityException {
		this.symmetric.createSymmetricEncryption();
	}

}
