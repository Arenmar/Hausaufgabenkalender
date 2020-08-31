package app;

import gui.HausaufgabenkalenderGUI;
import model.Aufgabenkalender;

public class AufgabenkalenderApp {

	public static void main(String[] args) {

		Aufgabenkalender kalender = new Aufgabenkalender();
		DataInitialization ini = new DataInitialization(kalender);
		new HausaufgabenkalenderGUI(kalender);
	}
}
