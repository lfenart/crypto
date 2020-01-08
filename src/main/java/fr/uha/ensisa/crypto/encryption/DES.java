package fr.uha.ensisa.crypto.encryption;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES extends AbstractSymmetricEncryption {

    private static final String name = "DES";

    public DES() throws GeneralSecurityException {
        super("DES/ECB/PKCS5Padding");
    }

    public byte[] createEncryption() throws GeneralSecurityException {
        byte[] bytes = null;
        // création d'une clé DES
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();
        // chiffrage
        this.chiffreur.init(Cipher.ENCRYPT_MODE, key);
        bytes = chiffreur.doFinal(input);
        // déchiffrage
        this.dechiffreur.init(Cipher.DECRYPT_MODE, key);
        bytes = dechiffreur.doFinal(bytes);
        return bytes;
    }

    @Override
    public String name() {
        return name;
    }

}