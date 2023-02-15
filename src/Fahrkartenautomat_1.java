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

		int TicketArt = FrageKunden(tastatur, Frage_TicketArt, 0, 4);
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
		if (TicketIndex == 1) {
			return 2.00;
		} else if (TicketIndex == 2) {
			return 3.00;
		} else if (TicketIndex == 3) {
			return 8.80;
		} else return 9.40;
	}

	public static double FahrkartenBezahlen(Scanner tastatur, double GesamtPreis) {

		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen;

		while (eingezahlterGesamtbetrag < GesamtPreis) {
			nochZuZahlen = GesamtPreis - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + String.format("%.2f", nochZuZahlen) + " Euro");
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			double eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag - GesamtPreis;
	}

	public static void RueckgabebetragAuszahlen(double rueckgabebetrag) {
		System.out.println("Der Rückgabebetrag in Höhe von " + String.format("%.2f", rueckgabebetrag) + " Euro");
		System.out.println("wird in folgenden Münzen ausgezahlt:");

		rueckgabebetrag = calc(rueckgabebetrag, 2.0, "2 Euro");
		rueckgabebetrag = calc(rueckgabebetrag, 1.0, "1 Euro");
		rueckgabebetrag = calc(rueckgabebetrag, 0.5, "50 Cent");
		rueckgabebetrag = calc(rueckgabebetrag, 0.2, "20 Cent");
		rueckgabebetrag = calc(rueckgabebetrag, 0.1, "10 Cent");
		calc(rueckgabebetrag, 0.05, "5 Cent");
	}

	public static double calc(double rueckgabebetrag, double muenze, String msg) {
		double Threshold = muenze - 0.00000001;

		while (rueckgabebetrag >= Threshold) {
			System.out.println(msg);
			rueckgabebetrag = rueckgabebetrag - muenze;
		}
		return rueckgabebetrag;
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