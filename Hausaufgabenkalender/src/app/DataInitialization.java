package app;

import model.Aufgabenkalender;
import model.Fach;
import model.Hausaufgabe;

public class DataInitialization {

	private Aufgabenkalender aufgabenkalender;

	public DataInitialization(Aufgabenkalender ak) {
		aufgabenkalender = ak;

		Fach d = new Fach("Deutsch");
		Fach eng = new Fach("Englisch");
		Fach frw = new Fach("Finanz- & Rechnungswesen");
		Fach f = new Fach("Französisch");
		Fach gup = new Fach("Geschichte & Politik");
		Fach inf = new Fach("Informatik");
		Fach m = new Fach("Mathematik");
		Fach tuu = new Fach("Technik & Umwelt");
		Fach wr = new Fach("Wirtschaft & Recht");

		ak.addFach(d);
		ak.addFach(eng);
		ak.addFach(frw);
		ak.addFach(f);
		ak.addFach(gup);
		ak.addFach(inf);
		ak.addFach(m);
		ak.addFach(tuu);
		ak.addFach(wr);

		d.addHausaufgabe(new Hausaufgabe("Goethe alle Gedichte auswendig lernen"));
		eng.addHausaufgabe(new Hausaufgabe("Shakespeare Hamlet lesen"));
		frw.addHausaufgabe(new Hausaufgabe("Buchhaltung UBS korrigieren"));
		f.addHausaufgabe(new Hausaufgabe("Franz macht doch sowieso keiner"));
		gup.addHausaufgabe(new Hausaufgabe("Neues Land eröffnen"));
		inf.addHausaufgabe(new Hausaufgabe("Windows 11 programmieren"));
		m.addHausaufgabe(new Hausaufgabe("Relativitätstheorie nachweisen"));
		tuu.addHausaufgabe(new Hausaufgabe("AKW bauen"));
		wr.addHausaufgabe(new Hausaufgabe("Alle Rechtsartikel auswendig lernen"));
	}
}
