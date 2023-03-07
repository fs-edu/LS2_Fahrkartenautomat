import java.util.Scanner;

public class Fahrkartenautomat_1 {

	static double[] Preise = {3.00, 3.50, 3.80, 2.00, 8.60, 9.20, 10.00, 9.40, 12.60, 13.80, 25.50, 26.00, 26.50};
	static String[] Tickets = {
			"Einzelfahrschein AB",
			"Einzelfahrschein BC",
			"Einzelfahrschein ABC",
			"Kurzstrecke AB",
			"Tageskarte AB",
			"Tageskarte BC",
			"Tageskarte ABC",
			"4-Fahrten-Karte AB",
			"4-Fahrten-Karte BC",
			"4-Fahrten-Karte ABC",
			"Kleingruppen-Tageskarte AB",
			"Kleingruppen-Tageskarte BC",
			"Kleingruppen-Tageskarte ABC"
	};

	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		TicketMenu();
		double GesamtPreis = FahrkartenbestellungErfassen(tastatur);
		System.out.println("\nGesamtpreis der Tickets: " + String.format("%.2f", GesamtPreis) + " Euro");

		double Rueckgabebetrag = FahrkartenBezahlen(tastatur, GesamtPreis);
		RueckgabebetragAuszahlen(Rueckgabebetrag);
		TicketAusdrucken();
		tastatur.close();
	}

	public static void TicketMenu() {
		String Header = "     | Ticket                    | Zone | Preis\n";
		String HeaderUnderline = "================================================";
		System.out.println(Header + HeaderUnderline);

		for (int i = 0; i < Tickets.length; i++) {
			String[] TicketsSplit = Tickets[i].split("\\s");
			System.out.printf("[%2d] | %-25s | %-4s | %.2f\n", i + 1, TicketsSplit[0], TicketsSplit[1], Preise[i]);
		}

		System.out.println("Auswahl: \f\r");
	}

	public static double FahrkartenbestellungErfassen(Scanner tastatur) {

		String Frage_Anzahl = "Anzahl der Tickets: ";
		String Frage_TicketArt = "Ticket: ";
		int TicketAuswahlMgl = Tickets.length;

		int TicketArt = FrageKunden(tastatur, Frage_TicketArt, 0, TicketAuswahlMgl);
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
		TicketIndex = TicketIndex - 1;
		return Preise[TicketIndex];
	}

	public static double FahrkartenBezahlen(Scanner tastatur, double GesamtPreis) {

		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen;

		while (eingezahlterGesamtbetrag < GesamtPreis) {
			nochZuZahlen = GesamtPreis - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + String.format("%.2f", nochZuZahlen) + " Euro");
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + tastatur.nextDouble();
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
		System.out.println("\n");
		System.out.println("""
				Vergessen Sie nicht, den Fahrschein
				vor Fahrtantritt entwerten zu lassen!
				Wir wünschen Ihnen eine gute Fahrt.""");
	}

}