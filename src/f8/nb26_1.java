package f8;

import java.util.Hashtable;

public class nb26_1 {
    public static void main(String[] args) {
        System.out.println(frequency(new String[]{
                "hej",
                "hejdå",
                "tjena",
                "hej",
                "tjabba",
                "tjo",
                "hej",
                "hejsan",
                "hejdå",
                "hej",
        }));
    }

    private static int frequency(String[] strings) {
        var freq = new Hashtable<String, Integer>();
        var maxFreq = 0;
        for(var s : strings)
        {
            var currentFreq = freq.get(s);
            if(currentFreq == null) currentFreq = 0;
            freq.put(s, ++currentFreq);
            if(currentFreq > maxFreq){
                maxFreq = currentFreq;
            }
        }
        return maxFreq;
    }
}
