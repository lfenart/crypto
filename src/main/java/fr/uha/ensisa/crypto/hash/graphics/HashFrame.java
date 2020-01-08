package fr.uha.ensisa.crypto.hash.graphics;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.crypto.graphics.AbstractFrame;
import fr.uha.ensisa.crypto.graphics.DropDown;
import fr.uha.ensisa.crypto.graphics.IDictionary;
import fr.uha.ensisa.crypto.graphics.Result;
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

public class HashFrame extends AbstractFrame {

	private HashDictionnary hashDictionnary;

	public HashFrame() throws NoSuchAlgorithmException {
		super("Hash");
	}

	@Override
	protected void start() {
		try {
			File f = new File(this.file.getText());
			byte[] bytes = IOUtils.getBytes(f);
			List<Result> results = new ArrayList<>();
			long iterations = ((Integer) this.iterations.getValue()).longValue();
			for (DropDown<String> d : this.dropDowns) {
				IHash hash = this.hashDictionnary.get((String) d.getComboBox().getSelectedItem());
				hash.setInput(bytes);
				HashTimer timer = new HashTimer(hash);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(hash, timer.getTime().toNanos()));
			}
			new HashResultFrame(results.toArray(new Result[] {}), iterations);
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
		return this.hashDictionnary;
	}

	@Override
	protected final void initDictionnary() throws GeneralSecurityException {
		this.hashDictionnary = new HashDictionnary();
		this.hashDictionnary.add(new MD2());
		this.hashDictionnary.add(new MD5());
		this.hashDictionnary.add(new SHA());
		this.hashDictionnary.add(new SHA224());
		this.hashDictionnary.add(new SHA256());
		this.hashDictionnary.add(new SHA384());
		this.hashDictionnary.add(new SHA512());
	}

}
