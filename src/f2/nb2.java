package f2;

public class nb2 {
    public static void main(String[] args) {
        // init
        var arr = new IntList(2);
        System.out.println(arr);

        // add end
        arr.add(1);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);

        // add in middle
        arr.add(1, 2);
        System.out.println(arr);

        // add end
        arr.add(arr.size(), 5);
        System.out.println(arr);

        // set
        arr.set(0, 99);
        System.out.println(arr);

        // remove begin
        arr.remove(0);
        System.out.println(arr);

        // remove middle
        arr.remove(2);
        System.out.println(arr);

        // remove end
        arr.remove(arr.size()-1);
        System.out.println(arr);
    }
}
