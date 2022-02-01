package f5;

import java.util.Scanner;

public class nb15 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Binary: ");
        System.out.println("Decimal: " + b2d(in.nextLine(), 0, 0));
        System.out.print("Decimal: ");
        System.out.println("Binary: " + d2b(Integer.parseInt(in.nextLine())));
    }

    private static int b2d(String binary, int bit, int decimal) {
        if (binary.length() == bit)
            return decimal;
        else {
            var cbit = binary.charAt(binary.length() - 1 - bit);
            decimal += cbit == '1'
                    ? (int) Math.pow(2, bit)
                    : 0;
            return b2d(binary, bit + 1, decimal);
        }
    }

    private static String d2b(int decimal) {
        String binary = ((decimal % 2 == 0) ? "0" : "1");

        if (decimal > 1) {
            binary = d2b(decimal / 2) + binary;
        }

        return binary;
    }
}

