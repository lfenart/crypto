package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class SHA512 extends AbstractHash {

    public SHA512() throws NoSuchAlgorithmException {
        super("SHA-512");
    }
    
}