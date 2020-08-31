package model;

/**
 * Die Klasse Hausaufgabe beschreibt eine Hausaufgabe. Die Hausaufgabe besteht aus dem Text
 * in welchem steht, was gemacht werden muss.
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 20 -04-2020
 */
public class Hausaufgabe {

	private String text;

	/**
	 * Erzeugt eine Hausaufgaben-Objekt mit dem Text.
	 *
	 * @param text Hausaufgabentext
	 */
	public Hausaufgabe(String text) {
		this.setText(text);
	}

	/**
	 * Setzt den Text.
	 *
	 * @param text Hausaufgabentext
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Liefert den Text der Hausaufgabe.
	 *
	 * @return Hausaufgabentext
	 */
	public String getText() {
		return text;
	}

	/**
	 * Liefert eine Stringrepräsentation der Klasse Hausaufgabe.
	 */
	public String toString() {
		return text;
	}
}
