package f9;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class nb29b {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shellsort(IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(20).toArray())));
    }

    private static int[] shellsort(int[] a) {
        var n = a.length;
        var gap = n/2;
        while(gap>0){
            for(var index = gap; index < n; index++){
                var data = a[index];
                var dataIndex = index;
                while (dataIndex > gap-1 && data < a[dataIndex-gap])
                {
                    a[dataIndex] = a[dataIndex-gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if(gap == 2) gap = 1;
            else gap /= 2.2;
        }
        return a;
    }
}
