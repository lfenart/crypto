package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class SHA224 extends AbstractHash {

    public SHA224() throws NoSuchAlgorithmException {
        super("SHA-224");
    }
    
}