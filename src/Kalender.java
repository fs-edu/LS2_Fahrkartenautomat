import java.util.Scanner;

public class Kalender {

    public static int findMonth(int monat) {

        // "Januar", "März", "Mai", "Juli", "August", "Oktober", "Dezember"
        Integer[] D31 = {1,3,5,7,9,12};
        // "April", "Juni", "September", "November"
        Integer[] D30 = {4,6,10,11};

        int tage = 0;

        for (Integer value : D31) {
            if (value == monat) {
                tage = 31;
                return tage;
            }
        }

        for (Integer integer : D30) {
            if (integer == monat) {
                tage = 30;
                return tage;
            }
        }

        // wenn februar
        return 28;
    }

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        System.out.println("Hallo, dies ist die Kalender App");
        System.out.print("Wie lautet der Monat (1-12): ");
        int Monat = tastatur.nextInt();

        Integer Tage = findMonth(Monat);
        System.out.printf("Der %d-te Monat im Jahr hat %d Tage.", Monat, Tage);

        tastatur.close();

    }

}
