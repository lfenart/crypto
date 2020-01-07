package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class SHA256 extends AbstractHash {

    public SHA256() throws NoSuchAlgorithmException {
        super("SHA-256");
    }
    
}