import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] Liste = {4, 2, 10, 3, -5, 0, 17};
        int ListLength = Liste.length;

        for (int j = 0; j < ListLength; j++) {
            int SmallestIdx = j;
            for (int i = j; i < ListLength; i++) {
                if (Liste[i] < Liste[SmallestIdx]) {
                    SmallestIdx = i;
                }
            }
            int temp = Liste[j];
            Liste[j] = Liste[SmallestIdx];
            Liste[SmallestIdx] = temp;
        }
        System.out.println(Arrays.toString(Liste));
    }
}
