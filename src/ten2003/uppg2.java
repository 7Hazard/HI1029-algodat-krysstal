package ten2003;

import java.util.Arrays;

public class uppg2 {
    static int calls = 0;
    public static void main(String[] args) {
        System.out.println(lay(20));
        System.out.println(calls);
    }

    static int lay(int len){
        int[] cache = new int[len+1]; // [0-7]
        Arrays.fill(cache, -1);
        return lay(len, 2, cache)
                + lay(len, 3, cache)
                + lay(len, 4, cache);
    }

    private static int lay(int len, int current, int[] cache) {
        calls++;
        if(current == len)
            return 1;
        else if(current > len)
            return 0;
        else if(cache[current] != -1)
            return cache[current];
        else
            return cache[current] = lay(len, current+2, cache)
                    + lay(len, current+3, cache)
                    + lay(len, current+4, cache);
    }
}
