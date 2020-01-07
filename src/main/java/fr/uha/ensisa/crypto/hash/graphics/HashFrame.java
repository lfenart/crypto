package fr.uha.ensisa.crypto.hash.graphics;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.uha.ensisa.crypto.graphics.AbstractDictionnary;
import fr.uha.ensisa.crypto.graphics.AbstractFrame;
import fr.uha.ensisa.crypto.graphics.DropDown;
import fr.uha.ensisa.crypto.hash.IHash;
import fr.uha.ensisa.crypto.hash.MD2;
import fr.uha.ensisa.crypto.hash.MD5;
import fr.uha.ensisa.crypto.hash.SHA;
import fr.uha.ensisa.crypto.hash.SHA224;
import fr.uha.ensisa.crypto.hash.SHA256;
import fr.uha.ensisa.crypto.hash.SHA384;
import fr.uha.ensisa.crypto.hash.SHA512;
import fr.uha.ensisa.crypto.hash.time.HashTimer;
import fr.uha.ensisa.crypto.io.IOUtils;
import fr.uha.ensisa.crypto.listener.MouseClickedListener;

public class HashFrame extends AbstractFrame {

	private HashDictionnary hashDictionnary;

	public HashFrame() throws NoSuchAlgorithmException {
		super("Hash");
		this.dropDowns = new ArrayList<>();
		this.hashDictionnary = new HashDictionnary();
		this.hashDictionnary.add(new MD2());
		this.hashDictionnary.add(new MD5());
		this.hashDictionnary.add(new SHA());
		this.hashDictionnary.add(new SHA224());
		this.hashDictionnary.add(new SHA256());
		this.hashDictionnary.add(new SHA384());
		this.hashDictionnary.add(new SHA512());

		this.addButton = new JButton("+");
		this.add(this.addButton);
		this.addButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addDropDown();
			}
		});

		this.file = new JTextField();
		this.file.setBounds(450, 50, 300, 25);
		this.add(this.file);

		JLabel fileLabel = new JLabel("Fichier :");
		fileLabel.setBounds(400, 50, 300, 25);
		this.add(fileLabel);

		JButton startButton = new JButton("Démarrer");
		startButton.setBounds(300, 500, 200, 50);
		startButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				start();
			}
		});
		this.add(startButton);

		this.addDropDown();

		this.setVisible(true);
	}

	private void start() {
		try {
			File f = new File(this.file.getText());
			byte[] bytes = IOUtils.getBytes(f);
			for (DropDown<String> d : this.dropDowns) {
				IHash hash = this.hashDictionnary.get((String) d.getComboBox().getSelectedItem());
				hash.setInput(bytes);
				HashTimer timer = new HashTimer(hash);
				timer.setIterations(100);
				timer.timeIt();
				System.out.println(timer.getTime().toNanos());
				// TODO
			}
		} catch (IOException e) {
			// TODO: No file found
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			HashFrame frame = new HashFrame();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected AbstractDictionnary dictionnary() {
		return this.hashDictionnary;
	}

}
