package fr.uha.ensisa.crypto.hash;

import java.security.NoSuchAlgorithmException;

public class SHA extends AbstractHash {

    public SHA() throws NoSuchAlgorithmException {
        super("SHA");
    }
    
}