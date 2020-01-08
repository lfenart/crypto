package fr.uha.ensisa.crypto.hash;

public interface IHash {

	public byte[] createHash();
	
	public boolean verify(byte[] bytes);

	public void setInput(byte[] input);

	public String name();

}