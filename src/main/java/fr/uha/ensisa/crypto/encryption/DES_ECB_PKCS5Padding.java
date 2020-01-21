package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES_ECB_PKCS5Padding extends AbstractSymmetricEncryption {

    private static final String name = "DES/ECB/PKCS5Padding";

    public DES_ECB_PKCS5Padding() throws GeneralSecurityException {
        super("DES", name);
    }

    @Override
    public String name() {
        return name;
    }

}
