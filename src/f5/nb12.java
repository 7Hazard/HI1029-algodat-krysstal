package f5;

public class nb12 {
    public static void main(String[] args) {
        System.out.println(powr(2, 3));
        System.out.println(powi(2, 3));
    }

    private static int powr(int base, int exp) {
        if (exp == 0) return 1;
        return base * powr(base, exp-1);
    }

    private static int powi(int base, int exp) {
        var val = 1;
        while (exp-- != 0) {
            val *= base;
        }
        return val;
    }
}
