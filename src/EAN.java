public class EAN {

    public static void loopOverArray(int[] Data) {

        double Total = 0;

        for (int i = 0; i < Data.length; i++) {

            int TempVal = Data[i];

            if (i % 2 != 0) {
                TempVal = TempVal * 3;
            }
            Total += TempVal;
        }

        int Checksum = 10 - (int) (Total % 10);
        String str = Integer.toString(Checksum);
        int Antwort = Integer.parseInt("" + str.charAt(0));
        System.out.println(Antwort);
    }

    public static void main(String[] args) {

        int[] TestCode = {9, 7, 8, 3, 8, 1, 5, 8, 2, 0, 8, 6};
        int[] TestCode2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 8};
        int[] TestCode3 = {9, 8, 0, 7, 5, 2, 2, 4, 5, 3, 6, 9, 4};
        loopOverArray(TestCode);
        loopOverArray(TestCode2);
        loopOverArray(TestCode3);
    }
}
