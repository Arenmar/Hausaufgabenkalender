package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Das GUI falls nichts zum Löschen ausgewählt wurde.
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 22-04-2020
 */

public class ErrorGUI extends JDialog {

	private GridBagConstraints gbc;

	private JPanel mainPanel;

	private JLabel message;

	/**
	 * Erstellt das GUI für das Errorfenster.
	 *
	 * @param parent
	 */
	public ErrorGUI(JFrame parent) {

		super(parent, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);

		mainPanel = new JPanel();

		message = new JLabel("Nichts zum löschen ausgewählt");

		init();
		pack();
		setVisible(true);
	}

	/**
	 * Initialisiert das GUI.
	 */
	public void init() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(message, gbc);
	}
}
