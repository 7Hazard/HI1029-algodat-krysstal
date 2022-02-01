package f6;

public class nb19 {
    public static void main(String[] args) {
        int[] board = new int[8];
        board[0] = board[1] = board[2] = 1; //black
        board[3] = 0; //empty
        board[4] = board[5] = board[6] = 2; //white

        solve(board, 3, "");
    }

    private static void solve(int[] board, int empty, String draws) {
        if (finished(board)) {
            System.out.println(draws);
            return;
        }
        if (empty > 1 && board[empty - 2] == 1) {
            board[empty - 2] = 0;
            board[empty] = 1;
            solve(board, empty - 2, draws + (empty - 2) + "->" + empty + ", ");
            board[empty - 2] = 1;
            board[empty] = 0;
        }

        if (empty > 0 && board[empty - 1] == 1) {
            board[empty - 1] = 0;
            board[empty] = 1;
            solve(board, empty - 1, draws + (empty - 1) + "->" + empty + ", ");
            board[empty - 1] = 1;
            board[empty] = 0;
        }

        if (empty < 6 && board[empty + 1] == 2) {
            board[empty + 1] = 0;
            board[empty] = 2;
            solve(board, empty + 1, draws + (empty + 1) + "->" + empty + ", ");
            board[empty + 1] = 2;
            board[empty] = 0;
        }

        if (empty < 5 && board[empty + 2] == 2) {
            board[empty + 2] = 0;
            board[empty] = 2;
            solve(board, empty + 2, draws + (empty + 2) + "->" + empty + ", ");
            board[empty + 2] = 2;
            board[empty] = 0;
        }
    }

    private static boolean finished(int[] board) {
        return board[0] == 2 && board[1] == 2 && board[2] == 2 && board[3] == 0 && board[4] == 1 && board[5] == 1 && board[6] == 1;
    }
}
