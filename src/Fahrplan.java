public class Fahrplan {

    public static void main(String[] args) {

        // Weichestellungen
        int fahrzeit = 0;
        char haltInSpandau = 'n';
        char richtungHamburg = 'n';
        char haltInStendal = 'j';
        char haltInWolfsburg = 'j';
        char haltInBraunschweig = 'j';
        String Msg = "Sie erreichen ";

        char endetIn = 'h';

        fahrzeit = fahrzeit + 8; // Fahrzeit Hbf -> Spandau

        if (haltInSpandau == 'j') {
            fahrzeit = fahrzeit + 2; // Halt in Spandau
        }
        //
        if (richtungHamburg == 'j') {
            fahrzeit = fahrzeit + 96;
            System.out.println(Msg + "Hamburg in " + fahrzeit);
            return;
        } else {
            fahrzeit = fahrzeit + 34;
        }
        //
        if (haltInStendal == 'j') {
            fahrzeit = fahrzeit + 16;
        } else {
            fahrzeit = fahrzeit + 6;
        }
        //
        if (haltInWolfsburg == 'j') {
            fahrzeit = fahrzeit + 29;
            System.out.println(Msg + "Wolfsburg in " + fahrzeit);
        } else if (haltInBraunschweig == 'j') {
            fahrzeit = fahrzeit + 50;
            System.out.println(Msg + "Braunschweig in " + fahrzeit);
        } else {
            fahrzeit = fahrzeit + 62;
            System.out.println(Msg + "Hannover in " + fahrzeit);
        }
    }
}
