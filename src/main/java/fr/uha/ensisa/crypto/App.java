package fr.uha.ensisa.crypto;

import org.bouncycastle.util.encoders.Hex;

import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.hash.MD5;
import fr.uha.ensisa.crypto.hash.time.HashTimer;
import fr.uha.ensisa.crypto.time.ITimer;

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
            IHash md5 = new MD5();
            md5.setInput(bytes);
            ITimer timer = new HashTimer(md5);
            timer.setIterations(N);
            timer.timeIt();
            long timeElapsed = timer.getTime().toNanos();
            System.out.println("Temps total : " + timeElapsed + "ns");
            System.out.println("Temps moyen : " + (double) timeElapsed / N + "ns");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
