package fr.uha.ensisa.crypto;

import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.uha.ensisa.crypto.encryption.graphics.AsymmetricFrame;
import fr.uha.ensisa.crypto.encryption.graphics.SymmetricFrame;
import fr.uha.ensisa.crypto.hash.graphics.HashFrame;
import fr.uha.ensisa.crypto.listener.MouseClickedListener;
import fr.uha.ensisa.crypto.mac.graphics.MacFrame;
import fr.uha.ensisa.crypto.signature.graphics.SignatureFrame;

public class App extends JFrame {

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
		macButton.addMouseListener(new MouseClickedListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new MacFrame();
				} catch (NoSuchAlgorithmException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(macButton);

		JButton signatureButton = new JButton("Signature");
		signatureButton.setBounds(300, 250, 200, 50);
		signatureButton.addMouseListener(new MouseClickedListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new SignatureFrame();
				} catch (NoSuchAlgorithmException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(signatureButton);

		JButton symmetricButton = new JButton("Symmetric");
		symmetricButton.setBounds(300, 350, 200, 50);
		symmetricButton.addMouseListener(new MouseClickedListener(){
		
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new SymmetricFrame();
				} catch (NoSuchAlgorithmException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(symmetricButton);

		JButton asymmetricButton = new JButton("Asymmetric");
		asymmetricButton.setBounds(300, 450, 200, 50);
		asymmetricButton.addMouseListener(new MouseClickedListener(){
		
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new AsymmetricFrame();
				} catch (NoSuchAlgorithmException ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(asymmetricButton);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new App();
	}

}
