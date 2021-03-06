package fr.uha.ensisa.crypto.mac.graphics;

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
import fr.uha.ensisa.crypto.mac.HmacMD5;
import fr.uha.ensisa.crypto.mac.HmacSHA1;
import fr.uha.ensisa.crypto.mac.HmacSHA224;
import fr.uha.ensisa.crypto.mac.HmacSHA256;
import fr.uha.ensisa.crypto.mac.HmacSHA384;
import fr.uha.ensisa.crypto.mac.HmacSHA512;
import fr.uha.ensisa.crypto.mac.IMAC;
import fr.uha.ensisa.crypto.mac.time.MACTimer;

public class MacFrame extends AbstractFrame {

	private MacDictionary macDictionary;

	public MacFrame() throws NoSuchAlgorithmException {
		super("MAC");
	}

	@Override
	protected void start() {
		try {
			File f = new File(this.file.getText());
			byte[] bytes = IOUtils.getBytes(f);
			List<Result> results = new ArrayList<>();
			long iterations = ((Integer) this.iterations.getValue()).longValue();
			for (DropDown<String> d : this.dropDowns) {
				IMAC mac = this.macDictionary.get((String) d.getComboBox().getSelectedItem());
				mac.setInput(bytes);
				MACTimer timer = new MACTimer(mac);
				timer.setIterations(iterations);
				timer.timeIt();
				results.add(new Result(mac, timer.getTime().toNanos()));
			}
			new MacResultFrame(results.toArray(new Result[] {}), iterations);
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
		return this.macDictionary;
	}

	@Override
	protected final void initDictionary() throws GeneralSecurityException {
		this.macDictionary = new MacDictionary();
		this.macDictionary.add(new HmacMD5());
		this.macDictionary.add(new HmacSHA1());
		this.macDictionary.add(new HmacSHA224());
		this.macDictionary.add(new HmacSHA256());
		this.macDictionary.add(new HmacSHA384());
		this.macDictionary.add(new HmacSHA512());
	}

}
