package fr.uha.ensisa.crypto.signature;


//import java.security.Signature;

public interface ISignature {
	
	
	//public Signature createSignature();
	
	//public void initialize();
	
	//public void update(byte[] tampon);
	
	public byte[] createSignature() throws Exception;
	
	//public void setFile(String file);
	

}
