package model;

import javax.swing.*;
import java.util.Vector;

/**
 * Die Klasse Fach sammelt Hausaufgaben.
 *
 * Für die Darstellung der Hausaufgaben wird eine Liste verwerndet. Deshalb implementiert die Klasse
 * das entsprechende Model (DefaultListModel).
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 20 -04-2020
 */
public class Fach extends DefaultListModel<Hausaufgabe> {

	public Vector<Hausaufgabe> hausaufgabenListe;
	private String fachName;

	/**
	 * Initialisierung der Klasse Fach für die Sammlung von Hausaufgaben.
	 *
	 * @param fachName der Name des Fachs
	 */
	public Fach(String fachName) {
		hausaufgabenListe = new Vector<Hausaufgabe>();
		this.fachName = fachName;
	}

	/**
	 * Liefert die Anzahl der Elemente in der Hausaufgabenliste (Vector: hausaufgabenListe).
	 *
	 * @return
	 */
	public int getSize() {
		return hausaufgabenListe.size();
	}

	/**
	 * Liefert den Namen des Fachs.
	 *
	 * @return Name vom Fach
	 */
	public String getFachName() {
		return fachName;
	}

	/**
	 * Fügt eine neue Hausaufgabe der Hausaufgabenliste (Vector: hausaufgabenListe) hinzu.
	 *
	 * @param hausaufgabe die Hausaufgabe
	 */
	public void addHausaufgabe(Hausaufgabe hausaufgabe) {
		hausaufgabenListe.add(hausaufgabe);
	}

	/**
	 * Liefert eine bestimmte Hausaufgabe aus der Hausaufgabenliste (Vector: hausaufgabenListe) an der Position index.
	 *
	 * @param index the index
	 * @return Hausaufgabe
	 */
	public String getHausaufgabe(int index) {
		return hausaufgabenListe.get(index).getText();
	}

	/**
	 * Entfernt die Hausaufgabe an der Postition index aus der Sammlung (Vector: hausaufgabenListe).
	 *
	 * @param index der Index
	 */
	public void removeHausaufgabe(int index) {
		hausaufgabenListe.remove(index);
	}

	/**
	 * Liefert eine Stringrepräsentation der Klasse Fach.
	 */
	public String toString() {
		String out = "Alle Hausaufgaben:\n";
		for (Hausaufgabe hausaufgabe : hausaufgabenListe) {
			out += hausaufgabe.toString() + "\n";
		}
		return out;
	}

	/**
	 * Liefert die Anzahl der Elemente in der Hausaufgabenliste (Vector: hausaufgabenListe).
	 *
	 * @return Anzahl Elemente
	 */
	public int getHaAnzahl() {
		return hausaufgabenListe.size();
	}
}
