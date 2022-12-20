import java.util.Scanner;

public class Kalender {

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        System.out.println("Hallo, dies ist die Kalender App");

        Integer[] D31 = {1,3,5,7,9,12};  // "Januar", "März", "Mai", "Juli", "August", "Oktober", "Dezember"
        Integer[] D30 = {4,6,10,11}; // "April", "Juni", "September", "November"

        int tage = 0;
        int monat;

        System.out.print("Wie lautet der Monat (1-12): ");
        monat = tastatur.nextInt();

        if (monat == 2 ) {
            tage = 28;
            System.out.printf("Der %d-te Monat im Jahr hat %d Tage.", monat, tage);
            return;
        }

        for (Integer value : D31) {
            if (value == monat) {
                tage = 31;
                System.out.printf("Der %d-te Monat im Jahr hat %d Tage.", monat, tage);
                return;
            }
        }

        for (Integer integer : D30) {
            if (integer == monat) {
                tage = 30;
                System.out.printf("Der %d-te Monat im Jahr hat %d Tage.", monat, tage);
                return;
            }
        }

        tastatur.close();

    }

}
