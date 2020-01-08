package fr.uha.ensisa.crypto;

import java.io.File;

import fr.uha.ensisa.crypto.encryption.AES;
import fr.uha.ensisa.crypto.encryption.DES;
import fr.uha.ensisa.crypto.encryption.IEncryption;
import fr.uha.ensisa.crypto.encryption.RSAEncryption;
import fr.uha.ensisa.crypto.encryption.time.EncryptionTimer;
import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.hash.MD5;
import fr.uha.ensisa.crypto.hash.time.HashTimer;
import fr.uha.ensisa.crypto.io.IOUtils;
import fr.uha.ensisa.crypto.mac.HmacSHA256;
import fr.uha.ensisa.crypto.mac.IMAC;
import fr.uha.ensisa.crypto.mac.timer.MACTimer;
import fr.uha.ensisa.crypto.signature.DSA;
import fr.uha.ensisa.crypto.signature.ISignature;
import fr.uha.ensisa.crypto.signature.RSA;
import fr.uha.ensisa.crypto.signature.SHA384withRSA;
import fr.uha.ensisa.crypto.signature.SHA512withRSA;
import fr.uha.ensisa.crypto.signature.time.SignatureTimer;
import fr.uha.ensisa.crypto.time.ITimer;
import fr.uha.ensisa.crypto.encryption.RC4;

/**
 * Hello world!
 *
 */
public class App {
	public static long N_HASH = 10_000_000;
	public static long N_MAC = 10_000;
	public static long N_SIGNATURE = 1_000;
	public static long N_SYMMETRIC = 1_000;
	public static long N_ASYMMETRIC = 100;
	

	public static void main(String[] args) {
		sha512rsa();
		dsa();
		sha384rsa();
		mac();
		rsa();
		md5();
		aes();
		rc4();
		des();
		rsaencryption();
	}
	
private static void sha512rsa() {
		
		try {
			ISignature sig = new SHA512withRSA();
			sig.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new SignatureTimer(sig);
			timer.setIterations(N_SIGNATURE);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("SHA512withRSA :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SIGNATURE + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void dsa() {
		try {
			ISignature sig = new DSA();
			sig.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new SignatureTimer(sig);
			timer.setIterations(N_SIGNATURE);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("DSA :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SIGNATURE + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void sha384rsa() {
		try {
			ISignature sig = new SHA384withRSA();
			sig.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new SignatureTimer(sig);
			timer.setIterations(N_SIGNATURE);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("SHA384withRSA :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SIGNATURE + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void mac() {
		try {
			IMAC mac = new HmacSHA256();
			mac.setInput("HELLO WORLD !".getBytes("UTF-8"));
			ITimer timer = new MACTimer(mac);
			timer.setIterations(N_MAC);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("MAC :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_MAC + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void md5() {
		try {
			byte[] bytes = "1234567890".getBytes("UTF-8");
//			byte[] empreinte = Hex.decode("e807f1fcf82d132f9bb018ca6738a19f");
			IHash md5 = new MD5();
			md5.setInput(bytes);
			ITimer timer = new HashTimer(md5);
			timer.setIterations(N_HASH);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("Md5 :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_HASH + "ns");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void rsa() {
		try {
			ISignature sig = new RSA();
			sig.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new SignatureTimer(sig);
			timer.setIterations(N_SIGNATURE);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("RSA :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SIGNATURE + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void aes() {
		try {
			IEncryption se = new AES();
			se.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new EncryptionTimer(se);
			timer.setIterations(N_SYMMETRIC);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("AES :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SYMMETRIC + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void rc4() {
		try {
			IEncryption se = new RC4();
			se.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new EncryptionTimer(se);
			timer.setIterations(N_SYMMETRIC);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("RC4 :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SYMMETRIC + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void des() {
		try {
			IEncryption se = new DES();
			se.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
			ITimer timer = new EncryptionTimer(se);
			timer.setIterations(N_SYMMETRIC);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("DES :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_SYMMETRIC + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void rsaencryption() {
		try {
			IEncryption se = new RSAEncryption();
			se.setInput(IOUtils.getBytes(new File("resources/Text to encrypt RSA.txt")));
			ITimer timer = new EncryptionTimer(se);
			timer.setIterations(N_ASYMMETRIC);
			timer.timeIt();
			long timeElapsed = timer.getTime().toNanos();
			System.out.println("RSA Encryption :");
			System.out.println("Temps total : " + timeElapsed + "ns");
			System.out.println("Temps moyen : " + (double) timeElapsed / N_ASYMMETRIC + "ns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
