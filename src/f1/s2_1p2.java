package f1;


import java.util.ArrayList;

public class s2_1p2 {
    public static void main(String[] args) {
        var arr = new ArrayList<String>();
        delete(arr, "car");
        System.out.println(arr);
    }

    /* Deletes the first occurrence of target in aList. */
    public static void delete(ArrayList<String> alist, String target) {
        // Metod 1
        alist.remove(target);

        // Metod 2
//        var index = alist.indexOf(target);
//        alist.remove(index);

        // Metod 3, borde inte göra detta och låta ArrayList göra sin grej
//        for (int i = index; i < alist.size(); i++) {
//            // bla bla bla
//        }
    }
}
