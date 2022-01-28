package f5;

import java.util.Scanner;

public class nb14_1 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        while (true) {
            System.out.print("Antal blåa: ");
            var blue = Integer.parseInt(in.nextLine());
            System.out.print("Antal vita: ");
            var white = Integer.parseInt(in.nextLine());
            System.out.print("Antal röda: ");
            var red = Integer.parseInt(in.nextLine());

            System.out.println("Antal växlingar: " + switches(0, blue, white, red));
        }
    }

    private static int switches(int count, int blue, int white, int red) {
        if (blue == white && white == red) return count;
        count++;
        if (count > 15) return Integer.MAX_VALUE;
        var b = switches(count, blue-1, white+1, red+3);
        var w = switches(count, blue+2, white-1, red+4);
        var r = switches(count, blue+1, white+5, red-1);
        return Math.min(b, Math.min(w, r));
    }
}
