package gui;

import model.Aufgabenkalender;
import model.Fach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Das Hauptfenster der Anwendung.
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 20 -04-2020
 */
public class HausaufgabenkalenderGUI extends JFrame {

	private DefaultListModel<String> haModel;

	private Fach fach;
	private Aufgabenkalender aufgabenkalender;
	private NeuGUI neuGUI;
	private ErrorGUI errorGUI;

	private JComboBox faecher;

	private JButton loeschen;
	private JButton neu;

	private JPanel mainPanel;
	private JPanel aufgabenPanel;
	private JPanel buttonPanel;
	private JPanel fachPanel;
	private JPanel cbPanel; // cbPanel = ComboBoxPanel
	private JPanel neuButtonPanel;

	private JList hausaufgaben;

	/**
	 * Erstellt das GUI für das Hauptfenster.
	 *
	 * @param aufgabenkalender der Aufgabenkalender
	 */
	public HausaufgabenkalenderGUI(Aufgabenkalender aufgabenkalender) {

		super("Hausaufgabenkalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.aufgabenkalender = aufgabenkalender;

		haModel = new DefaultListModel<>();

		faecher = new JComboBox();
		faecher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haModel.clear();
				setContent(faecher.getSelectedIndex());
			}
		});

		for (int i = 0; i < aufgabenkalender.getFachListe().size(); i++) {
			faecher.addItem(aufgabenkalender.getFach(i).getFachName());
		}

		loeschen = new JButton("Löschen");
		loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onLoeschen(e);
			}
		});

		neu = new JButton("Neu");
		neu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onNeu(e);
			}
		});

		mainPanel = new JPanel();
		aufgabenPanel = new JPanel();
		buttonPanel = new JPanel();
		fachPanel = new JPanel();
		cbPanel = new JPanel();
		neuButtonPanel = new JPanel();

		hausaufgaben = new JList(haModel);

		init();
		pack();
		setResizable(true);
		setVisible(true);
		//System.out.println(faecher.getSelectedIndex()); <-- Zum debuggen
	}

	/**
	 * Initialisiert das GUI.
	 */
	private void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(aufgabenPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.EAST);
		mainPanel.add(fachPanel, BorderLayout.WEST);

		aufgabenPanel.setLayout(new GridLayout());
		aufgabenPanel.add(hausaufgaben);

		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(neuButtonPanel, BorderLayout.SOUTH);
		neuButtonPanel.setLayout(new GridLayout(2, 1));
		neuButtonPanel.add(neu);
		neuButtonPanel.add(loeschen);

		fachPanel.setLayout(new BorderLayout());
		fachPanel.add(cbPanel, BorderLayout.WEST);
		cbPanel.add(faecher, BorderLayout.NORTH);

		//System.out.println(aufgabenkalender.getFach(0).getHausaufgabe(0)); <-- Zum debuggen
	}

	/**
	 * Wird aufgerufen wenn der Button [Löschen] getätigt wird.
	 * Die ausgewählte Hausaufgabe wird gelöscht.
	 *
	 * @param e das ActionEvent
	 * @throws ArrayIndexOutOfBoundsException die Exception wenn keine Hausaufgabe zum Löschen ausgewählt wurde
	 */
	private void onLoeschen(ActionEvent e) throws ArrayIndexOutOfBoundsException {
		try{
			if (aufgabenkalender.getFach(faecher.getSelectedIndex()).getHaAnzahl() != 0) {
				aufgabenkalender.getFach(faecher.getSelectedIndex()).removeHausaufgabe(hausaufgaben.getSelectedIndex());
				haModel.clear();
				setContent(faecher.getSelectedIndex());
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			errorGUI = new ErrorGUI(this);
		}
	}

	/**
	 * Wird aufgerufen wenn der Button [Neu] getätigt wird.
	 * Das Fenster zum Erstellen einer neuen Hausaufgabe öffnet sich.
	 *
	 * @param e das ActionEvent
	 */
	public void onNeu(ActionEvent e) {
		neuGUI = new NeuGUI(this, aufgabenkalender, faecher.getSelectedIndex());
		haModel.clear();
		setContent(faecher.getSelectedIndex());
	}

	/**
	 * Setzt die neue Hausaufgabe in das Hauptfenster der Anwendung unter dem richtigen Fach.
	 *
	 * @param index der Index des ausgesuchten Faches (ComboBox: "faecher")
	 */
	private void setContent(int index) {
		Vector<Fach> fachListe = new Vector<>();
		fachListe = aufgabenkalender.getFachListe();
		if(fachListe.get(index).getHaAnzahl() == 0) {
			haModel.addElement("");
		} else {
			for (int i = 0; i < fachListe.get(index).getHaAnzahl(); i++) {
				haModel.addElement(fachListe.get(index).getHausaufgabe(i));
			}
		}
	}
}
