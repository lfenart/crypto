package fr.uha.ensisa.crypto.graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class DropDown<E> {

	private JComboBox<E> comboBox;
	private JButton button;

	public DropDown() {

	}

	public DropDown(JComboBox<E> comboBox, JButton button) {
		this.comboBox = comboBox;
		this.button = button;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public void setComboBox(JComboBox<E> comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox<E> getComboBox() {
		return this.comboBox;
	}

}
