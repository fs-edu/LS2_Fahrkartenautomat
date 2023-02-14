import java.util.Scanner;

public class Fahrkartenautomat_1 {
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		Begruessung();
		double GesamtPreis = FahrkartenbestellungErfassen(tastatur);
		System.out.println("\nGesamtpreis der Tickets: " + String.format("%.2f", GesamtPreis) + " Euro");

		double Rueckgabebetrag = FahrkartenBezahlen(tastatur, GesamtPreis);
		RueckgabebetragAuszahlen(Rueckgabebetrag);
		TicketAusdrucken();
		tastatur.close();
	}

	public static void Begruessung() {
		//	Ausgabe der Begrüßung
		System.out.println("Herzlich Willkommen!");
		System.out.println("Wählen Sie ihre Fahrkarte für Berlin AB aus:\n");
		System.out.println("(1)\tKurzstrecke AB [2,00€]");
		System.out.println("(2)\tEinzelfahrschein AB [3,00€]");
		System.out.println("(3)\tTageskarte AB [8,80€]");
		System.out.println("(4)\t4-Fahrten-Karte AB [9,40€]");
	}

	public static double FahrkartenbestellungErfassen(Scanner tastatur) {

		String Frage_Anzahl = "Anzahl der Tickets: ";
		String Frage_TicketArt = "Ticket: ";

		int TicketArt = FrageKunden(tastatur, Frage_TicketArt, 1, 4);
		int TicketAnzahl = FrageKunden(tastatur, Frage_Anzahl, 0, 10);
		double TicketPreis = getTicketPreis(TicketArt);

		return TicketPreis * TicketAnzahl;
	}

	public static int FrageKunden(Scanner tastatur, String Frage, int MinWert, int MaxWert) {

		System.out.print(Frage);
		int userInput = tastatur.nextInt();

		if (userInput > MinWert && userInput <= MaxWert) {
			return userInput;
		} else {
			System.out.println("ungültige Eingabe!");
			return FrageKunden(tastatur, Frage, MinWert, MaxWert);
		}
	}

	public static double getTicketPreis(int TicketIndex) {
		double output = 0.0;
		switch (TicketIndex) {
			case 1:
				output = 2.00;
			case 2:
				output = 3.00;
			case 3:
				output = 8.80;
			case 4:
				output = 9.40;
		}
		return output;
	}

	public static double FahrkartenBezahlen(Scanner tastatur, double GesamtPreis) {
		System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");

		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;

		while (eingezahlterGesamtbetrag < GesamtPreis) {
			double eingeworfeneMuenze = tastatur.nextDouble();
			nochZuZahlen = GesamtPreis - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + String.format("%.2f", nochZuZahlen) + " Euro");
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag - GesamtPreis;
	}

	public static void RueckgabebetragAuszahlen(double rueckgabebetrag) {

		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + String.format("%.2f", rueckgabebetrag) + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 0.9) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.49) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.19) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.09) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.049) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}
	}

	public static void TicketAusdrucken() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");

		System.out.println("""
				Vergessen Sie nicht, den Fahrschein
				vor Fahrtantritt entwerten zu lassen!
				Wir wünschen Ihnen eine gute Fahrt.""");
	}

}