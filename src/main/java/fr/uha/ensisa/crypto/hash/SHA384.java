package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class SHA384 extends AbstractHash {

    public SHA384() throws NoSuchAlgorithmException {
        super("SHA-384");
    }
    
}