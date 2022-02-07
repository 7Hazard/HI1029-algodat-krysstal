package f7;

import java.util.Scanner;

public class nb20 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter nr of queens or 0 to terminate program.");
            Scanner scan = new Scanner(System.in);
            var input = scan.nextInt();
            if (input == 0)
                break;
            ChessBoard board = new ChessBoard(input);
            board.print();
            board.addQueen();
        }
    }

    public static class ChessBoard {
        private boolean[][] board;
        private boolean[] lDiagonal;
        private boolean[] rDiagonal;
        int rows;
        int cols;
        int size;

        public ChessBoard(int size) {
            this.size = size;
            rows = cols = size;
            board = new boolean[rows][cols];
            lDiagonal = new boolean[size * 2];
            rDiagonal = new boolean[size * 2];
        }

        public void print() {
            for (int i = 0; i < rows; i++) {
                System.out.println();
                for (int j = 0; j < cols; j++) {
                    if (board[i][j]) {
                        // we have found a queen
                        System.out.print("|Q|");
                    } else {
                        //found nothing
                        System.out.print("|X|");
                    }
                }
            }
            System.out.println();
        }

        public void clearBoard() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++)
                    board[i][j] = false;
            }
            for (int i = 0; i < size * 2; i++) {
                rDiagonal[i] = false;
                lDiagonal[i] = false;
            }
        }

        private boolean checkCol(int col) {
            for (int i = 0; i < size; i++) {
                if (board[i][col])
                    return false;
            }
            return true;
        }

        private void updateDiagonal(int row, int column, boolean status) {
            rDiagonal[row + column] = status;
            lDiagonal[row - column + size - 1] = status;
        }

        public void addQueen() {
            for (int sol = 0; sol < size; sol++) {
                addQueen(1, sol);
                System.out.println("solution: " + (sol + 1));

                clearBoard();
            }
        }

        private boolean addQueen(int row, int col) {
            for (int i = 0; i < cols; i++) {
                col = (col + 1) % size; //if end of row wrap around.
                if (checkCol(col) && !rDiagonal[row - 1 + col] && !lDiagonal[row - 1 - col + size - 1]) {// we check if there is any queen in the row
                    board[row - 1][col] = true;
                    updateDiagonal(row - 1, col, true);
                    if (row == size) {
                        print();
                    } else {
                        if (addQueen(row + 1, col)) {
                            return true;
                        } else {
                            board[row - 1][col] = false;
                            updateDiagonal(row - 1, col, false);
                        }
                    }
                }
            }
            return false;
        }

    }

}
