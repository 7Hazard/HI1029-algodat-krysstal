package f5;

public class nb13 {
    public static void main(String[] args) {
        System.out.println(sqrt(64));
    }

    private static int sqrt(int val) {
        return sqrt(val, 1, 3);
    }

    private static int sqrt(int n, int a, int e) {
        if (Math.abs(a*a - n) < e) return a;
        return sqrt(n, (a*a+n)/(2*a), e);
    }
}
