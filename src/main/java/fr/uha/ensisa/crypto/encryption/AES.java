package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES extends AbstractSymmetricEncryption {

    private static final String name = "AES";

    public AES() throws GeneralSecurityException {
        super(name);
    }

    @Override
    public String name() {
        return name;
    }

}
