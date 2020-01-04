package fr.uha.ensisa.crypto;

import java.io.File;

import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.hash.MD5;
import fr.uha.ensisa.crypto.hash.time.HashTimer;
import fr.uha.ensisa.crypto.io.IOUtils;
import fr.uha.ensisa.crypto.signature.ISignature;
import fr.uha.ensisa.crypto.signature.RSA;
import fr.uha.ensisa.crypto.signature.time.SignatureTimer;
import fr.uha.ensisa.crypto.time.ITimer;
import fr.uha.ensisa.crypto.messaging.MACGenerator;
import fr.uha.ensisa.crypto.mac.MACAlgorithms;

/**
 * Hello world!
 *
 */
public class App {
	public static long N_HASH = 10_000_000;
	public static long N_SIGNATURE = 1_000;

	public static void main(String[] args) throws Exception {
		//rsa();
		md5();
		mac();

	}
	private static void mac() throws Exception {
		
		MACGenerator gen = new MACGenerator("7367523e34564a2461347470463e383659333836266d6f552b7326443b3b3334");
		String ccid = "Metropolis";
		String uuid = "302345612";
		String date = "2/11/2019 8:48:15 AM";
		String message = "METROPOLIS02/11/2019302345612";
		String message2 = "302345612METROPOLIS";
		boolean isHex = true;
		System.out.println("-----------");
		System.out.println("SHA256: " + gen.encodeMessage(MACAlgorithms.ENCODING_STRENGTH_SHA256, ccid, uuid, date, isHex));
		System.out.println("SHA512: " + gen.encodeMessage(MACAlgorithms.ENCODING_STRENGTH_SHA512, ccid, uuid, date, isHex));
		System.out.println("MD5 full message: " + gen.encodeMessage(MACAlgorithms.ENCODING_STRENGTH_MD5, message2, isHex));
		System.out.println("MD5 composite message: " + gen.encodeMessage(MACAlgorithms.ENCODING_STRENGTH_MD5, ccid, uuid, date, isHex));
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
	
}
