package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class MD5 extends AbstractHash {

    public MD5() throws NoSuchAlgorithmException {
        super("MD5");
    }
    
}