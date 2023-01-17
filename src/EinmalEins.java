public class EinmalEins {

    public static void forLoop(int current) {

        String Result = "";

        for (int i = 1; i <= 10; i++) {
            int Temp = i * current;
            Result = Result + "\t" + Temp;
        }
        System.out.println(Result);
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            forLoop(i);
        }

    }
}
