package fr.uha.ensisa.crypto.hash;

/**
 * 
 * Contract for hash objects
 * @author Lucas Fénart
 *
 */

public interface IHash {

	public byte[] createHash();
	
	public boolean verify(byte[] bytes);

	public void setInput(byte[] input);

	public String name();

}