package fr.uha.ensisa.crypto.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

public class AbstractResultFrame extends JFrame {

	public AbstractResultFrame(String name) {
		super(name);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		this.setLayout(null);
	}

}
