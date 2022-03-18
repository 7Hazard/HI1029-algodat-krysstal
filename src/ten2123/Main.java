package ten2123;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int width = 6, height = 6;
//        int[][] matrix = {
//                {2, 5, 2, 2, 5, 3},
//                {14, 11, 4, 7, 2, 7},
//                {9, 12, 1, 3, 7, 4},
//                {7, 8, 2, 4, 1, 2},
//                {6, 8, 1, 2, 0, 1},
//                {5, 4, 3, 9, 1, 9}
//        };
        int[][] matrix = {
                {2, 3, 4, 5, 6, 3},
                {14, 11, 4, 7, 7, 7},
                {9, 12, 1, 3, 8, 4},
                {7, 8, 2, 4, 9, 2},
                {6, 8, 1, 2, 0, 1},
                {5, 4, 3, 9, 1, 9}
        };

        class State {
            final int x, y;
            final HashSet<Integer> visited;
            final int steps;
            public State(int x, int y, int steps, HashSet<Integer> visited) {
                this.x = x;
                this.y = y;
                this.steps = steps;
                this.visited = new HashSet<>(visited);
                this.visited.add(matrix[x][y]);
            }

            public State next(int x, int y) {
                return new State(x, y, steps+1, visited);
            }

            boolean isRightValid() {
                return x+1 < width && !visited.contains(matrix[x+1][y]);
            }

            public boolean isDownValid() {
                return y+1 < height && !visited.contains(matrix[x][y+1]);
            }

            public boolean isLeftValid() {
                return x-1 >= 0 && !visited.contains(matrix[x-1][y]);
            }

            public boolean isUpValid() {
                return y-1 >= 0 && !visited.contains(matrix[x][y-1]);
            }
        }

        var queue = new ArrayDeque<State>();
        queue.add(new State(0, 0, 0, new HashSet<>())); // top left

        while (!queue.isEmpty()) {
            var state = queue.pollFirst();

            // Check if reached end
            if(state.visited.contains(0)) {
                // shortest-1 eftersom både start/slut räknas med
                System.out.println(state.steps);
                break;
            }

            // right
            if (state.isRightValid())
                queue.add(state.next(state.x+1, state.y));
            // down
            if (state.isDownValid())
                queue.add(state.next(state.x, state.y+1));
            // left
            if (state.isLeftValid())
                queue.add(state.next(state.x-1, state.y));
            // up
            if (state.isUpValid())
                queue.add(state.next(state.x, state.y-1));
        }
    }
}
