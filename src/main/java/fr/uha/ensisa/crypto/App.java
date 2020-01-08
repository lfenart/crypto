package fr.uha.ensisa.crypto;

import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.uha.ensisa.crypto.hash.graphics.HashFrame;
import fr.uha.ensisa.crypto.listener.MouseClickedListener;

/**
 * Hello world!
 *
 */
public class App extends JFrame {
//	public static long N_HASH = 10_000_000;
//	public static long N_SIGNATURE = 1_000;
//	public static long N_SYMMETRIC = 1_000;
//	public static long N_ASYMMETRIC = 100;

	public App() {
		super("Cryptogaphie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(null);

		JButton hashButton = new JButton("Hash");
		hashButton.setBounds(300, 50, 200, 50);
		hashButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new HashFrame();
				} catch (NoSuchAlgorithmException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(hashButton);

		JButton macButton = new JButton("MAC");
		macButton.setBounds(300, 150, 200, 50);
		this.add(macButton);

		JButton signatureButton = new JButton("Signature");
		signatureButton.setBounds(300, 250, 200, 50);
		this.add(signatureButton);

		JButton symmetricButton = new JButton("Symmetric");
		symmetricButton.setBounds(300, 350, 200, 50);
		this.add(symmetricButton);

		JButton asymmetricButton = new JButton("Asymmetric");
		asymmetricButton.setBounds(300, 450, 200, 50);
		this.add(asymmetricButton);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new App();
	}

//	public static void md5() {
//		try {
//			byte[] bytes = "1234567890".getBytes("UTF-8");
////			byte[] empreinte = Hex.decode("e807f1fcf82d132f9bb018ca6738a19f");
//			IHash md5 = new MD5();
//			md5.setInput(bytes);
//			ITimer timer = new HashTimer(md5);
//			timer.setIterations(N_HASH);
//			timer.timeIt();
//			long timeElapsed = timer.getTime().toNanos();
//			System.out.println("Md5 :");
//			System.out.println("Temps total : " + timeElapsed + "ns");
//			System.out.println("Temps moyen : " + (double) timeElapsed / N_HASH + "ns");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private static void rsa() {
//		try {
//			ISignature sig = new RSA();
//			sig.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
//			ITimer timer = new SignatureTimer(sig);
//			timer.setIterations(N_SIGNATURE);
//			timer.timeIt();
//			long timeElapsed = timer.getTime().toNanos();
//			System.out.println("RSA :");
//			System.out.println("Temps total : " + timeElapsed + "ns");
//			System.out.println("Temps moyen : " + (double) timeElapsed / N_SIGNATURE + "ns");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	private static void aes() {
//		try {
//			IEncryption se = new AES();
//			se.setInput(IOUtils.getBytes(new File("resources/PlainTextFile.txt")));
//			ITimer timer = new EncryptionTimer(se);
//			timer.setIterations(N_SYMMETRIC);
//			timer.timeIt();
//			long timeElapsed = timer.getTime().toNanos();
//			System.out.println("AES :");
//			System.out.println("Temps total : " + timeElapsed + "ns");
//			System.out.println("Temps moyen : " + (double) timeElapsed / N_SYMMETRIC + "ns");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	private static void rsaencryption() {
//		try {
//			IEncryption se = new RSAEncryption();
//			se.setInput(IOUtils.getBytes(new File("resources/Text to encrypt RSA.txt")));
//			ITimer timer = new EncryptionTimer(se);
//			timer.setIterations(N_ASYMMETRIC);
//			timer.timeIt();
//			long timeElapsed = timer.getTime().toNanos();
//			System.out.println("RSA Encryption :");
//			System.out.println("Temps total : " + timeElapsed + "ns");
//			System.out.println("Temps moyen : " + (double) timeElapsed / N_ASYMMETRIC + "ns");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
}
