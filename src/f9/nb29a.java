package f9;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class nb29a {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergesort(IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(20).toArray())));
    }

    private static int[] mergesort(int[] a) {
        if(a.length == 1) return a;

        var b = Arrays.copyOfRange(a, 0, a.length/2);
        var c = Arrays.copyOfRange(a, a.length/2, a.length);
        mergesort(b);
        mergesort(c);
        merge(b, c, a);

        return a;
    }

    private static void merge(int[] b, int[] c, int[] a) {
        int indexa = 0, indexb = 0, indexc = 0, n = b.length, m = c.length;
        while (indexa < n && indexb < m) {
            if (b[indexa] <= c[indexb])
                a[indexc++] = b[indexa++];
            else
                a[indexc++] = c[indexb++];
        }
        while (indexa < n)
            a[indexc++] = b[indexa++];
        while (indexb < m)
            a[indexc++] = c[indexb++];
    }
}
