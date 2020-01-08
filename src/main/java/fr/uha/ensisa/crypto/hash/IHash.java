package fr.uha.ensisa.crypto.hash;

/**
 * 
 * Contract for hash objects
 * @author Lucas Fénart
 *
 */

public interface IHash {

	/**
	 * Create the hash of the input set using setInput
	 * @return hash of the input
	 */
	public byte[] createHash();
	
	/**
	 * Verify that the parameter is the hash of the input
	 * @param bytes the hash to verify
	 * @return true if the hash is verified, false if not
	 */
	public boolean verify(byte[] bytes);

	/**
	 * Set the input
	 * @param input input
	 */
	public void setInput(byte[] input);
	
	/**
	 * Get the name of the IHash
	 * @return name
	 */
	public String name();

}