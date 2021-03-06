package fr.uha.ensisa.crypto.encryption.graphics;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uha.ensisa.crypto.graphics.AbstractResultFrame;
import fr.uha.ensisa.crypto.graphics.Result;
import fr.uha.ensisa.crypto.encryption.IEncryption;

public class SymmetricResultFrame extends AbstractResultFrame {

	public SymmetricResultFrame(Result[] results, long iterations) {
		super("Symmetric result");

		String[] columnNames = { "Algorithm", "Time (ns)", "Iterations", "Average Time (ns)" };
		Object[][] data = new Object[results.length][columnNames.length];
		for (int i = 0; i < results.length; i++) {
			data[i][0] = ((IEncryption) results[i].getObject()).name();
			data[i][1] = results[i].getTime();
			data[i][2] = iterations;
			data[i][3] = results[i].getTime() / iterations;
		}
		JTable table = new JTable(data, columnNames);
		table.setBounds(0, 100, 800, 600);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 800, 600);
		this.add(scrollPane);

		this.setVisible(true);
	}

}
