package ten20210318;

import java.util.ArrayList;
import java.util.Arrays;

public class uppg7recu {
    public static void main(String[] args) {
        // 0,1,2,3,4,5,6,7,8
        int[] numbers = new int[]{8,1,3,6,4,5,7,2,0};
        System.out.println(solve(numbers));
    }

    private static ArrayList<Integer> solve(int[] numbers) {
        // find empty pos
        var to = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) to = i;
        }
        return next(to, numbers, new ArrayList<>());
    }

    private static ArrayList<Integer> move(int[] numbers, int from, int to, ArrayList<Integer> moves) {
        // from -> to
        var switched = Arrays.copyOf(numbers, numbers.length);
        switched[to] = numbers[from];
        switched[from] = 0;

        // mark number that was moved
        moves = new ArrayList<>(moves);
        moves.add(numbers[from]);

        // find movables and store solutions
        return next(from, switched, moves);
    }

    private static ArrayList<Integer> next(int to, int[] numbers, ArrayList<Integer> moved) {
        // reached max or if solved
        if(moved.size() > 15)
            return null;
        else if(Arrays.equals(numbers, new int[]{1,2,3,4,5,6,7,8,0}))
            return moved;

        if(to == 8) {
            return min(
                    // 1 to 8
                    move(numbers, 1, 8, moved),
                    // 3 to 8
                    move(numbers, 3, 8, moved),
                    // 5 to 8
                    move(numbers, 5, 8, moved),
                    // 7 to 8
                    move(numbers, 7, 8, moved)
            );
        } else {
            // back
            var fromBack = to == 0 ? 7 : to-1;
            // front
            var fromFront = to == 7 ? 0 : to+1;

            if (to == 1 || to == 3 || to == 5 || to == 7)
                return min(
                        move(numbers, fromFront, to, moved),
                        move(numbers, fromBack, to, moved),
                        move(numbers, 8, to, moved)
                );
            else
                return min(
                        move(numbers, fromFront, to, moved),
                        move(numbers, fromBack, to, moved)
                );
        }
    }

    private static ArrayList<Integer> min(ArrayList<Integer>... solutions) {
        ArrayList<Integer> min = null;
        for (ArrayList<Integer> solution : solutions) {
            if(min == null || (solution != null && solution.size() < min.size())){
                min = solution;
            }
        }
        return min;
    }
}
