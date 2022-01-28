package f5;

public class nb11 {
    public static void main(String[] args) {
        var array = new int[]{4, 6, 2, 9, 1, 93, 10, 5, 67};
        System.out.println(largetInt(array, 0));
    }

    private static int largetInt(int[] array, int fromIndex) {
        var n1 = array[fromIndex];
        if (fromIndex == array.length-1) return n1;
        var n2 = largetInt(array, fromIndex+1);
        return Math.max(n1, n2);
    }
}
