package f9;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class nb28 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(20).toArray())));
        System.out.println(Arrays.toString(insertionSort(IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(20).toArray())));
    }

    private static int[] selectionSort(int[] a) {
        for (int index = 0; index < a.length - 1; index++) {
            int minIndex = index;
            for (int i = index+1; i < a.length; i++) {
                if (a[i] < a[minIndex])
                    minIndex = i;
            }
            var t = a[index];
            a[index] = a[minIndex];
            a[minIndex] = t;
        }
        return a;
    }

    private static int[] insertionSort(int[] a) {
        for (int index = 0; index < a.length; index++) {
            var data = a[index];
            var dataIndex = index;
            while (dataIndex > 0 && data < a[dataIndex-1])
            {
                a[dataIndex] = a[dataIndex-1];
                dataIndex--;
            }
            a[dataIndex] = data;
        }
        return a;
    }
}
