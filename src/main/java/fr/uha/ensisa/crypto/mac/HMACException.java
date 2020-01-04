package fr.uha.ensisa.crypto.mac;

public class HMACException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public HMACException(String message) {
		super(message);
	}

	
	public HMACException(String message, Throwable t) {
		super(message, t);
	}

}
