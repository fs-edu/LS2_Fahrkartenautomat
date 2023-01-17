import java.util.Scanner;

public class Addieren {
    public static void whileLoop(int UserInput) {
        System.out.println("Starte While Loop");
        int SUM = 0;
        while (UserInput > 0) {
            SUM += UserInput;
            System.out.println(UserInput);
            UserInput = UserInput - 1;
        }
        System.out.println("Die Summe ist: " + SUM);
    }

    public static void forLoop(int UserInput) {
        System.out.println("Starte For Loop");
        int SUM = 0;
        for (int i = UserInput; i > 0; --i) {
            SUM += i;
            System.out.println(i);
        }
        System.out.println("Die Summe ist: " + SUM);
    }

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        // Input erfragen
        System.out.println("Zahl eingeben:");
        int UserInput = tastatur.nextInt();
        // Methode erfragen
        System.out.println("Methode auswählen:");
        System.out.println("[1] WHILE LOOP\n[2] FOR LOOP");
        int Choice = tastatur.nextInt();

        if (Choice == 1) {
            whileLoop(UserInput);
        } else if (Choice == 2) {
            forLoop(UserInput);
        } else {
            System.out.println("ungültige Eingabe");
        }
    }

}
