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
import fr.uha.ensisa.crypto.encryption.AES;
import fr.uha.ensisa.crypto.encryption.AES_CBC_PKCS5PADDING;
import fr.uha.ensisa.crypto.encryption.AES_CFB8_NoPadding;
import fr.uha.ensisa.crypto.encryption.DES_ECB_PKCS5Padding;
import fr.uha.ensisa.crypto.encryption.DESede_CBC_ISO10126Padding;
import fr.uha.ensisa.crypto.encryption.IEncryption;
import fr.uha.ensisa.crypto.encryption.RC4;
import fr.uha.ensisa.crypto.encryption.RC5_CFB_PKCS5Padding;
import fr.uha.ensisa.crypto.encryption.time.EncryptionTimer;

public class SymmetricFrame extends AbstractFrame {

	private EncryptionDictionary encryptionDictionary;

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
				IEncryption encryption = this.encryptionDictionary.get((String) d.getComboBox().getSelectedItem());
				encryption.setInput(bytes);
				EncryptionTimer timer = new EncryptionTimer(encryption);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(encryption, timer.getTime().toNanos()));
			}
			new SymmetricResultFrame(results.toArray(new Result[] {}), iterations);
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
		return this.encryptionDictionary;
	}

	@Override
	protected final void initDictionary() throws GeneralSecurityException {
		this.encryptionDictionary = new EncryptionDictionary();
		this.encryptionDictionary.add(new AES());
		this.encryptionDictionary.add(new AES_CBC_PKCS5PADDING());
		this.encryptionDictionary.add(new AES_CFB8_NoPadding());
		this.encryptionDictionary.add(new DES_ECB_PKCS5Padding());
		this.encryptionDictionary.add(new DESede_CBC_ISO10126Padding());
		this.encryptionDictionary.add(new RC4());
		//this.encryptionDictionary.add(new RC5_CFB_PKCS5Padding());
	}

}
