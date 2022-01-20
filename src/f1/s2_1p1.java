package f1;


import java.util.ArrayList;

public class s2_1p1 {
    public static void main(String[] args) {
        var arr = new ArrayList<String>();
        arr.add("bike");
        replace(arr, "bike", "car");
        System.out.println(arr);
    }

    /* Rep1aces each occurrence of o1ditem in aList with newitem. */
    public static void replace(ArrayList<String> alist, String olditem, String newitem) {
        for (int i = 0; i < alist.size(); i++) {
            if(alist.get(i).equals(olditem))
                alist.set(i, newitem);
        }
    }
}
