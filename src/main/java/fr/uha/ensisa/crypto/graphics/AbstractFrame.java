package fr.uha.ensisa.crypto.graphics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import fr.uha.ensisa.crypto.listener.MouseClickedListener;

public abstract class AbstractFrame extends JFrame {

	private static final int DROP_DOWN_X = 50;
	private static final int DROP_DOWN_WIDTH = 100;
	private static final int DROP_DOWN_HEIGHT = 50;

	protected List<DropDown<String>> dropDowns;
	protected JButton addButton;
	protected JTextField file;
	protected JSpinner iterations;

	public AbstractFrame(String name) {
		super(name);
		try {
			this.initDictionnary();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		this.dropDowns = new ArrayList<>();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		this.setLayout(null);

		this.addButton = new JButton("+");
		this.add(this.addButton);
		this.addButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				addDropDown();
			}
		});

		this.file = new JTextField();
		this.file.setBounds(500, 50, 175, 25);
		this.add(this.file);

		JLabel fileLabel = new JLabel("Fichier :");
		fileLabel.setBounds(400, 50, 100, 25);
		this.add(fileLabel);

		JButton fileButton = new JButton("Ouvrir");
		fileButton.setBounds(700, 50, 75, 25);
		fileButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					file.setText(f.getAbsolutePath());
				}
			}
		});
		this.add(fileButton);

		this.iterations = new JSpinner(new SpinnerNumberModel(1000, 1, Integer.MAX_VALUE, 1));
		this.iterations.setBounds(500, 100, 175, 25);
		this.add(this.iterations);

		JLabel iterationLabel = new JLabel("Iterations :");
		iterationLabel.setBounds(400, 100, 100, 25);
		this.add(iterationLabel);

		JButton startButton = new JButton("Démarrer");
		startButton.setBounds(450, 300, 200, 50);
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

	protected void addDropDown() {
		if (this.dropDowns.size() >= 7)
			return;
		String[] list = this.dictionnary().keySet().toArray(new String[] {});
		DropDown<String> dropDown = new DropDown<String>();
		dropDown.setComboBox(new JComboBox<String>(list));
		int y = 50 + DROP_DOWN_HEIGHT * 3 / 2 * this.dropDowns.size();
		dropDown.getComboBox().setBounds(DROP_DOWN_X, y, DROP_DOWN_WIDTH, DROP_DOWN_HEIGHT);
		this.add(dropDown.getComboBox());
		this.dropDowns.add(dropDown);

		this.addButton.setBounds(DROP_DOWN_X, y + DROP_DOWN_HEIGHT * 3 / 2, DROP_DOWN_WIDTH, DROP_DOWN_HEIGHT);

		JButton deleteButton = new JButton("X");
		deleteButton.setBounds(DROP_DOWN_X + DROP_DOWN_WIDTH + 50, y, DROP_DOWN_WIDTH, DROP_DOWN_HEIGHT);
		deleteButton.addMouseListener(new MouseClickedListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				removeDropDown(dropDown);
			}
		});
		this.add(deleteButton);
		dropDown.setButton(deleteButton);

		this.repaint();
	}

	protected final void removeDropDown(DropDown<String> dropDown) {
		int index = this.dropDowns.indexOf(dropDown);
		this.removeDropDown(index);
	}

	protected final void removeDropDown(int index) {
		if (this.dropDowns.size() <= 1)
			return;
		this.remove(this.dropDowns.get(index).getComboBox());
		this.remove(this.dropDowns.get(index).getButton());
		this.dropDowns.remove(index);
		for (int i = index; i < this.dropDowns.size(); i++) {
			this.dropDowns.get(i).getComboBox().setBounds(DROP_DOWN_X, 50 + DROP_DOWN_HEIGHT * 3 / 2 * i,
					DROP_DOWN_WIDTH, DROP_DOWN_HEIGHT);
			this.dropDowns.get(i).getButton().setBounds(DROP_DOWN_X + DROP_DOWN_WIDTH + 50,
					50 + DROP_DOWN_HEIGHT * 3 / 2 * i, DROP_DOWN_WIDTH, DROP_DOWN_HEIGHT);
		}
		this.addButton.setBounds(DROP_DOWN_X, 50 + DROP_DOWN_HEIGHT * 3 / 2 * this.dropDowns.size(), DROP_DOWN_WIDTH,
				DROP_DOWN_HEIGHT);
		this.repaint();
	}

	protected abstract IDictionary dictionnary();

	protected abstract void start();

	protected abstract void initDictionnary() throws GeneralSecurityException;
}
