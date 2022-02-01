package f6;

import java.io.BufferedReader;
import java.io.StringReader;

public class nb18 {
    public static void main(String[] args) {
        Maze m = new Maze(maze1);
        m.print();
        System.out.println();
        if (m.solve()) {
            m.print();
            System.out.println("Solved");
            System.out.println();
        } else System.out.println("Unsolved");
    }

    public static class Maze {

        int rows, columns;

        public enum Cell {WALL, OPEN, CORRECT, VISITED}

        private Position currentP, goal;
        Cell[][] mazeMatrix;

        public Maze(String maze) {
            try {
                BufferedReader in = new BufferedReader(new StringReader(maze));
                rows = Integer.parseInt(in.readLine()) + 2;
                columns = Integer.parseInt(in.readLine()) + 2;
                mazeMatrix = new Cell[rows][columns];
                for (int j = 0; j < columns; j++) {
                    mazeMatrix[0][j] = Cell.WALL;
                    mazeMatrix[rows - 1][j] = Cell.WALL;
                }
                for (int i = 1; i < rows - 1; i++) {
                    mazeMatrix[i][0] = Cell.WALL;
                    mazeMatrix[i][columns - 1] = Cell.WALL;
                }
                for (int i = 1; i < rows - 1; i++) {
                    String s = in.readLine();
                    for (int j = 1; j < columns - 1; j++) {
                        mazeMatrix[i][j] = Cell.OPEN;
                        if (s.charAt(j - 1) == '*')
                            mazeMatrix[i][j] = Cell.WALL;
                        else if (s.charAt(j - 1) == 'g') {
                            goal = new Position(i, j);
                        } else if (s.charAt(j - 1) == 's') {
                            currentP = new Position(i, j);
                        }
                    }
                }
                in.close();
            } catch (Throwable e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        private static class Position {
            int row, column;

            public Position(int r, int c) {
                row = r;
                column = c;
            }

            public boolean equals(Position p) {
                return (row == p.row && column == p.column);
            }
        }

        public boolean solve() {
            return solve(currentP);
        }

        private boolean solve(Position p) {
            var up = mazeMatrix[p.row - 1][p.column];
            var down = mazeMatrix[p.row + 1][p.column];
            var left = mazeMatrix[p.row][p.column - 1];
            var right = mazeMatrix[p.row][p.column + 1];

            mazeMatrix[p.row][p.column] = Cell.CORRECT;
            if (p.equals(goal)) {
                return true;
            } else {
                if (up == Cell.OPEN)//up
                {
                    if (solve(new Position(p.row - 1, p.column))) {
                        return true;
                    }
                }
                if (right == Cell.OPEN)//höger
                {
                    if (solve(new Position(p.row, p.column + 1))) {
                        return true;
                    }
                }
                if (down == Cell.OPEN)//ned
                {
                    if (solve(new Position(p.row + 1, p.column))) {
                        return true;
                    }
                }
                if (left == Cell.OPEN)//vänster
                {
                    if (solve(new Position(p.row, p.column - 1))) {
                        return true;
                    }
                }
                mazeMatrix[p.row][p.column] = Cell.VISITED;
                return false;

            }
        }

        public void print() {
            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < columns - 1; j++)
                    System.out.print(mazeMatrix[i][j].ordinal());
                System.out.println();
            }
        }
    }

    static String maze1 = """
            9
            27
            *s*************************
            *               *         *
            * ***** ******* * ******* *
            *          *    * *     * *
            **** * ***** ** * * * * * *
            *    *     * *    * * * * *
            * ** ******* * **** *** * *
            *       *    *       *  * *
            ***********************g***
            """;
}
