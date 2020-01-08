package fr.uha.ensisa.crypto.encryption.graphics;

import java.awt.Graphics;
import java.io.File;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.uha.ensisa.crypto.graphics.IDictionary;
import fr.uha.ensisa.crypto.graphics.AbstractFrame;
import fr.uha.ensisa.crypto.graphics.DropDown;
import fr.uha.ensisa.crypto.graphics.Result;
import fr.uha.ensisa.crypto.io.IOUtils;
import fr.uha.ensisa.crypto.encryption.IEncryption;
import fr.uha.ensisa.crypto.encryption.RSAEncryption;
import fr.uha.ensisa.crypto.encryption.time.EncryptionTimer;

public class AsymmetricFrame extends AbstractFrame {

	private EncryptionDictionnary encryptionDictionnary;

	public AsymmetricFrame() throws NoSuchAlgorithmException {
		super("Asymmetric");
	}

	@Override
	protected void start() {
		try {
			File f = new File(this.file.getText());
			byte[] bytes = IOUtils.getBytes(f);
			List<Result> results = new ArrayList<>();
			long iterations = ((Integer) this.iterations.getValue()).longValue();
			for (DropDown<String> d : this.dropDowns) {
				IEncryption encryption = this.encryptionDictionnary.get((String) d.getComboBox().getSelectedItem());
				encryption.setInput(bytes);
				EncryptionTimer timer = new EncryptionTimer(encryption);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(encryption, timer.getTime().toNanos()));
			}
			new AsymmetricResultFrame(results.toArray(new Result[] {}), iterations);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setVisible(true);
	}

	@Override
	protected IDictionary dictionnary() {
		return this.encryptionDictionnary;
	}

	@Override
	protected final void initDictionnary() throws GeneralSecurityException {
		this.encryptionDictionnary = new EncryptionDictionnary();
		this.encryptionDictionnary.add(new RSAEncryption());
	}

}
