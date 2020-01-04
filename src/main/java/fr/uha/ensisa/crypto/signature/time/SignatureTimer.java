package fr.uha.ensisa.crypto.signature.time;

import java.security.GeneralSecurityException;

import fr.uha.ensisa.crypto.signature.ISignature;
import fr.uha.ensisa.crypto.time.AbstractTimer;

public class SignatureTimer extends AbstractTimer {

	private ISignature sig;

	public SignatureTimer() {

	}

	public SignatureTimer(ISignature sig) {
		this.sig = sig;
	}

	public void setSignature(ISignature sig) {
		this.sig = sig;
	}

	@Override
	protected void run() {
		try {
			byte[] sig = this.sig.createSignature();
			this.sig.verifySignature(sig);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

}
