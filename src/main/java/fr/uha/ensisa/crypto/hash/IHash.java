package fr.uha.ensisa.crypto.hash;

public interface IHash {

	public byte[] createHash();

	public void setInput(byte[] input);

	public String name();

}