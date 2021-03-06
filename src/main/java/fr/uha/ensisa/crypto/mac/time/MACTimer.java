package fr.uha.ensisa.crypto.mac.time;

import java.security.GeneralSecurityException;

import fr.uha.ensisa.crypto.mac.IMAC;
import fr.uha.ensisa.crypto.time.AbstractTimer;

public class MACTimer extends AbstractTimer{
	
	private IMAC mac;
	
	public MACTimer(IMAC mac) {
		this.mac = mac ;
	}

	public void setMAC(IMAC mac) {
		this.mac = mac;
	}
	
	@Override
	protected void run() throws GeneralSecurityException {
		this.mac.createMAC();
	}

}
