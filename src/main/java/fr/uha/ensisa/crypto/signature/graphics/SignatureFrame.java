package fr.uha.ensisa.crypto.signature.graphics;

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
import fr.uha.ensisa.crypto.signature.ISignature;
import fr.uha.ensisa.crypto.signature.SHA1withDSA;
import fr.uha.ensisa.crypto.signature.SHA256withRSA;
import fr.uha.ensisa.crypto.signature.SHA384withRSA;
import fr.uha.ensisa.crypto.signature.SHA512withRSA;
import fr.uha.ensisa.crypto.signature.time.SignatureTimer;

public class SignatureFrame extends AbstractFrame {

	private SignatureDictionary signatureDictionary;

	public SignatureFrame() throws NoSuchAlgorithmException {
		super("Signature");
	}

	@Override
	protected void start() {
		try {
			File f = new File(this.file.getText());
			byte[] bytes = IOUtils.getBytes(f);
			List<Result> results = new ArrayList<>();
			long iterations = ((Integer) this.iterations.getValue()).longValue();
			for (DropDown<String> d : this.dropDowns) {
				ISignature signature = this.signatureDictionary.get((String) d.getComboBox().getSelectedItem());
				signature.setInput(bytes);
				SignatureTimer timer = new SignatureTimer(signature);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(signature, timer.getTime().toNanos()));
			}
			new SignatureResultFrame(results.toArray(new Result[] {}), iterations);
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
		return this.signatureDictionary;
	}

	@Override
	protected final void initDictionary() throws GeneralSecurityException {
		this.signatureDictionary = new SignatureDictionary();
		this.signatureDictionary.add(new SHA1withDSA());
		this.signatureDictionary.add(new SHA256withRSA());
		this.signatureDictionary.add(new SHA384withRSA());
		this.signatureDictionary.add(new SHA512withRSA());
	}

}
