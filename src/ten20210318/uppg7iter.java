package ten20210318;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class uppg7iter {
    public static void main(String[] args) {
        // 0,1,2,3,4,5,6,7,8
        int[] numbers = new int[]{8,1,3,6,4,5,7,2,0};
        System.out.println(solve(numbers));
    }

    private static ArrayList<Integer> solve(int[] numbers) {
        // find empty pos
        var emptyStart = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) emptyStart = i;
        }

        var queue = new ArrayDeque<State>();
        queue.add(new State(emptyStart, numbers, new ArrayList<>()));
        while (!queue.isEmpty()) {
            var state = queue.poll();

            // check if solved
            if (state.moves.size() > 15)
                continue;
            else if (Arrays.equals(state.numbers, new int[]{1,2,3,4,5,6,7,8,0}))
                return state.moves;

            if (state.empty == 8) {
                // 1 to 8
                queue.add(move(state, 1, 8));
                // 3 to 8
                queue.add(move(state, 3, 8));
                // 5 to 8
                queue.add(move(state, 5, 8));
                // 7 to 8
                queue.add(move(state, 7, 8));
            } else {
                var to = state.empty;

                // front
                var front = to == 0 ? 7 : to-1;
                queue.add(move(state, front, to));
                // back
                var back = to == 7 ? 0 : to+1;
                queue.add(move(state, back, to));

                if (to == 1 || to == 3 || to == 5 || to == 7)
                    queue.add(move(state, 8, to));
            }
        }

        return null;
    }

    private static State move(State state, int from, int to) {
        var switched = Arrays.copyOf(state.numbers, state.numbers.length);
        switched[to] = state.numbers[from];
        switched[from] = 0;

        var moves = new ArrayList<>(state.moves);
        moves.add(state.numbers[from]);

        return new State(from, switched, moves);
    }

    private static class State {
        private final int empty;
        private final int[] numbers;
        private final ArrayList<Integer> moves;

        public State(int empty, int[] numbers, ArrayList<Integer> moves) {
            this.empty = empty;
            this.numbers = numbers;
            this.moves = moves;
        }
    }
}
