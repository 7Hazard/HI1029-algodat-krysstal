package ten2123;

import java.util.ArrayList;
import java.util.HashSet;

public class MainRecurse {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 5, 2, 2, 5, 3},
                {14, 11, 4, 7, 2, 7},
                {9, 12, 1, 3, 7, 4},
                {7, 12, 1, 3, 7, 4},
                {6, 8, 1, 2, 0, 1},
                {5, 4, 3, 9, 1, 9}
        };

        System.out.println(new Solver(matrix).shortest);
    }

    static class Solver {
        private final int[][] matrix;
        int shortest = -1;
        int width = 6, height = 6;

        Solver(int[][] matrix) {
            this.matrix = matrix;

            var steps = new ArrayList<>();
            steps.add(new Pos(0,0));
            var visited = new HashSet<>();
            visited.add(matrix[0][0]);

            // right
            traverse(1, 0, visited, steps);
            // down
            traverse(0, 1, visited, steps);
        }

        private void traverse(int x, int y, HashSet<Object> visited, ArrayList<Object> steps) {
            var pos = new Pos(x, y);
            if(x >= 0 && x < width && visited.contains(pos) && steps.contains(pos))
                return;

//            if (matrix[x][y] == 0)
        }


        private class Pos {
            private final int x;
            private final int y;

            public Pos(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
