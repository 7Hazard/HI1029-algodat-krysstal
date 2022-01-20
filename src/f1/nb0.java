package f1;

public class nb0 {
    public static void main(String[] args) {
        var array = new NArrayList<String>();
        array.add("Hej");
        array.add("på");
        array.add("dig");
        System.out.println(array);

        array.remove(1);
        System.out.println(array);


    }
}
