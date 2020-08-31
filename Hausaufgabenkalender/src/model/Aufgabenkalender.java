package model;

import javax.swing.*;
import java.util.Vector;

/**
 * Die Klasse Aufgabenkalender sammelt die Fächer. Sie ermöglicht das Filtern nach einem Fach.
 *
 * Für die Darstellung der Themen wird eine Dropbox verwendet.
 * Daher implementiert die Klasse das entsprechende Model (DefaultComboBoxModel).
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 20 -04-2020
 */
public class Aufgabenkalender extends DefaultComboBoxModel<Fach> {

	private Vector<Fach> fachListe;

	/**
	 * Initialisierung der Klasse Aufgabenkalender für die Sammlung von Fächern.
	 */
	public Aufgabenkalender() {
		fachListe = new Vector<>();
	}

	/**
	 * Fügt der Sammlung ein neues Fach hinzu (Vector: fachListe).
	 *
	 * @param fach das Fach
	 */
	public void addFach(Fach fach) {
		fachListe.add(fach);
	}

	/**
	 * Liefert das Fach an der Stelle index (Vector: fachListe).
	 *
	 * @param index the index
	 * @return das Fach
	 */
	public Fach getFach(int index) {
		return fachListe.get(index);
	}

	/**
	 * Liefert die Anzahl der Elemente in der Fachliste (Vector: fachListe).
	 *
	 * @return Anzahl der Elemente
	 */
	public int getSize() {
		return fachListe.size();
	}

	/**
	 * Liefert die vollständige Liste der Fächer (Vector: fachListe).
	 *
	 * @return die fachListe
	 */
	public Vector<Fach> getFachListe() {
		return fachListe;
	}
}
