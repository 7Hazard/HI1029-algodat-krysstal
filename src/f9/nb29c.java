package f9;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class nb29c {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quicksort(IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(20).toArray())));
    }

    private static int[] quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
        return a;
    }

    private static void quicksort(int[] a, int first, int last) {
        if(first < last) {
            int pivIndex = partition(a, first, last);
            quicksort(a, first, pivIndex-1);
            quicksort(a, pivIndex+1, last);
        }
    }

    private static int partition(int[] a, int first, int last) {
        int pivot = a[first];
        int up = first;
        int down = last;
        do {
            while (up < last && pivot >= a[up])
                up++;
            while(pivot < a[down])
                down--;
            if(up < down) {
                // swap up and down
                var t = a[up];
                a[up] = a[down];
                a[down] = t;
            }
        } while(up < down);

        // Swap first and down
        var t = a[first];
        a[first] = a[down];
        a[down] = t;

        return down;
    }
}
