package fr.uha.ensisa.crypto.encryption.graphics;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.crypto.graphics.IDictionary;
import fr.uha.ensisa.crypto.graphics.AbstractFrame;
import fr.uha.ensisa.crypto.graphics.DropDown;
import fr.uha.ensisa.crypto.graphics.Result;
import fr.uha.ensisa.crypto.io.IOUtils;
import fr.uha.ensisa.crypto.encryption.AES;
import fr.uha.ensisa.crypto.encryption.DES;
import fr.uha.ensisa.crypto.encryption.IEncryption;
import fr.uha.ensisa.crypto.encryption.RC4;
import fr.uha.ensisa.crypto.encryption.time.EncryptionTimer;

public class SymmetricFrame extends AbstractFrame {

	private EncryptionDictionnary encryptionDictionnary;

	public SymmetricFrame() throws NoSuchAlgorithmException {
		super("Symmetric");
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
			new SymmetricResultFrame(results.toArray(new Result[] {}), iterations);
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

	@Override
	protected IDictionary dictionnary() {
		return this.encryptionDictionnary;
	}

	@Override
	protected final void initDictionnary() throws GeneralSecurityException {
		this.encryptionDictionnary = new EncryptionDictionnary();
		this.encryptionDictionnary.add(new AES());
		this.encryptionDictionnary.add(new DES());
		this.encryptionDictionnary.add(new RC4());
		// this.encryptionDictionnary.add(new RC5());
	}

}
