package fr.uha.ensisa.crypto.signature.graphics;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.crypto.graphics.AbstractDictionnary;
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

	private SignatureDictionnary signatureDictionnary;

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
				ISignature signature = this.signatureDictionnary.get((String) d.getComboBox().getSelectedItem());
				signature.setInput(bytes);
				SignatureTimer timer = new SignatureTimer(signature);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(signature, timer.getTime().toNanos()));
			}
			new SignatureResultFrame(results.toArray(new Result[] {}), iterations);
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
	protected AbstractDictionnary dictionnary() {
		return this.signatureDictionnary;
	}

	@Override
	protected final void initDictionnary() throws GeneralSecurityException {
		this.signatureDictionnary = new SignatureDictionnary();
		this.signatureDictionnary.add(new SHA1withDSA());
		this.signatureDictionnary.add(new SHA256withRSA());
		this.signatureDictionnary.add(new SHA384withRSA());
		this.signatureDictionnary.add(new SHA512withRSA());
	}

}
