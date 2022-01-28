package f5;

import java.util.Scanner;

public class nb14 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Vilken poäng ska uppnås: ");
        var goal = Integer.parseInt(in.nextLine());
        var kronor = nextCoin(0, 1, goal);
        if (kronor == -1)
            System.out.println("Cannot reach points exactly");
        else
            System.out.println("Poängen kan nås med " + kronor + " kronor");
    }

    private static int nextCoin(int kr, int points, int goal) {
        if (points > goal) return -1;
        if (points == goal) return kr;
        var ten = nextCoin(kr+10, points*3, goal);
        var five = nextCoin(kr+5, points+4, goal);
        if (ten != -1 && five != -1)
            return Math.min(ten, five);
        else if (ten != -1) return ten;
        else return five;
    }
}
