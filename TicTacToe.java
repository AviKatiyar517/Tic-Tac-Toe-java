
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';

        initializeBoard();

        while (true) {
            printBoard();

            System.out.println("Player " + currentPlayer + ", enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    break;
                }

                if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Cell already occupied! Try again.");
            }
        }

        sc.close();
    }

    // Initialize board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print board
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
        System.out.println();
    }

    // Check winner
    public static boolean checkWinner(char player) {

        // rows & columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Check draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
