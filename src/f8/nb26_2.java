package f8;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class nb26_2 {

    public static void main(String[] args) {
        System.out.println(unique(new String[]{
                "hej",
                "hejdå",
                "tjena",    // 1
                "hej",
                "tjabba",   // 2
                "tjo",      // 3
                "hej",
                "hejsan",   // 4
                "hejdå",
                "hej",
                "bye"       // 5
        }));
    }

    private static int unique(String[] strings) {
        var unique = new HashSet<String>();
        for (String s : strings) {
            unique.add(s);
        }
        return unique.size();

//        var unique = new HashSet<String>();
//        var notunique = new HashSet<String>();
//        for(var s : strings)
//        {
//            if(unique.contains(s)) {
//                unique.remove(s);
//                notunique.add(s);
//            } else if(!notunique.contains(s)) {
//                unique.add(s);
//            }
//        }
//        return unique.size();
    }
}
