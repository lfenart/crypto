package fr.uha.ensisa.crypto.signature;

//import java.security.Signature;

public interface ISignature {

	public byte[] createSignature() throws Exception;

	public void setInput(byte[] input);

}
