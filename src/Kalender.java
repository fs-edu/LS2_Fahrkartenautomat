public class Kalender {
	public static void main(String[] args) {

		String[] Kalender = {
				"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"
		};

		for (int i = 0; i < 12; i++) {
			Integer Monat = i + 1;
			String Name = Kalender[i];
			Integer Tage = getLength(i);
			System.out.printf("\n" + Name + ", der %d-te Monat im Jahr, hat %d Tage.", Monat, Tage);
		}

	}

	public static int getLength(Integer Month) {
		if (Month == 2) {
			return 28;
		} else if (Month % 2 == 0) {
			return 31;
		} else {
			return 30;
		}
	}
}
