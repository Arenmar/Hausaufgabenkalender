package gui;

import model.Aufgabenkalender;
import model.Hausaufgabe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Stellt das GUI für die Eingabe neuer Hausaufgaben bereit.
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 21 -04-2020
 */
public class NeuGUI extends JDialog{

	private DefaultListModel<Hausaufgabe> haModel;

	private Aufgabenkalender aufgabenkalender;

	private JPanel mainPanel;
	private JPanel cbPanel; // cbPanel = ComboBoxPanel
	private JPanel buttonPanel1; // 2 Button Panels um die Buttons unten rechts in gleicher Grösse zu behalten
	private JPanel buttonPanel2;

	private JTextField aufgabeInput;

	private JComboBox faecher;

	private JButton speichern;
	private JButton verwerfen;

	/**
	 * Erstellt das GUI für das Eingabefenster.
	 *
	 * @param parent           das Parentfenster
	 * @param aufgabenkalender der Aufgabenkalender
	 */
	public NeuGUI(JFrame parent, Aufgabenkalender aufgabenkalender, int selectedIndex) {

		super(parent, true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.aufgabenkalender = aufgabenkalender;

		mainPanel = new JPanel();
		cbPanel = new JPanel();
		buttonPanel1 = new JPanel();
		buttonPanel2 = new JPanel();

		aufgabeInput = new JTextField(25);

		faecher = new JComboBox();
		for (int i = 0; i < aufgabenkalender.getFachListe().size(); i++) {
			faecher.addItem(aufgabenkalender.getFach(i).getFachName());
		}
		faecher.setSelectedIndex(selectedIndex);
		//System.out.println(aufgabenkalender.getFachListe().size()); <-- Zum debuggen

		speichern = new JButton("Speichern");
		speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSpeichern(e);
			}
		});

		verwerfen = new JButton("Verwerfen");
		verwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onVerworfen(e);
			}
		});

		init();
		pack();
		setVisible(true);
	}

	/**
	 * Initialisiert das GUI.
	 */
	public void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(cbPanel, BorderLayout.WEST);
		mainPanel.add(buttonPanel1, BorderLayout.EAST);

		mainPanel.add(aufgabeInput, BorderLayout.CENTER);

		cbPanel.add(faecher, BorderLayout.NORTH);

		buttonPanel1.setLayout(new BorderLayout());
		buttonPanel1.add(buttonPanel2, BorderLayout.SOUTH);
		buttonPanel2.setLayout(new GridLayout(2, 1));
		buttonPanel2.add(speichern);
		buttonPanel2.add(verwerfen);
	}

	/**
	 * Wird aufgerufen wenn der Button [Speichern] betätigt wird.
	 * Eine neue Hausaufgabe wird dem Hauptfenster hinzugefügt.
	 *
	 * @param e das ActionEvent
	 */
	public void onSpeichern(ActionEvent e) {
		if (!aufgabeInput.getText().isEmpty()) {
			aufgabenkalender.getFach(faecher.getSelectedIndex()).addHausaufgabe(new Hausaufgabe(aufgabeInput.getText()));
			dispose();
		}
	}

	/**
	 * Wird aufgerufen wenn der Button [Verwerfen] betätigt wird. Das Fenster wird geschlossen.
	 *
	 * @param e das ActionEvent
	 */
	public void onVerworfen(ActionEvent e) {
		dispose();
	}
}
