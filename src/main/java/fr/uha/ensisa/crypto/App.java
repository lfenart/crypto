package fr.uha.ensisa.crypto;

import java.security.MessageDigest;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/**
 * Hello world!
 *
 */
public class App {
    public static long N = 10_000_000;

    public static void main(String[] args) {
        md5();
    }

    public static void md5() {
        try {
            byte[] bytes = "1234567890".getBytes("UTF-8");
            byte[] empreinte = Hex.decode("e807f1fcf82d132f9bb018ca6738a19f");
            MessageDigest md = MessageDigest.getInstance("MD5");
            Instant start = Instant.now();
            for (long i = 0; i < N; i++) {
                byte[] out = md.digest(bytes);
                if (!Arrays.equals(empreinte, out)) {
                    throw new RuntimeException("empreinte non conforme");
                }
            }
            Instant end = Instant.now();
            long timeElapsed = Duration.between(start, end).toNanos();
            System.out.println("Temps total : " + timeElapsed + "ns");
            System.out.println("Temps moyen : " + (double) timeElapsed / N + "ns");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
