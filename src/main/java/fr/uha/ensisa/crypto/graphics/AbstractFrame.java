package fr.uha.ensisa.crypto.graphics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.uha.ensisa.crypto.listener.MouseClickedListener;

public abstract class AbstractFrame extends JFrame {

	private static final int DROP_DOWN_X = 50;
	private static final int DROP_DOWN_WIDTH = 100;
	private static final int DROP_DOWN_HEIGHT = 50;

	protected List<DropDown<String>> dropDowns;
	protected JButton addButton;
	protected JTextField file;

	public AbstractFrame(String name) {
		super(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		this.setLayout(null);
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

	protected abstract AbstractDictionnary dictionnary();
}
