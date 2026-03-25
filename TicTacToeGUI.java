import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI {
    JFrame frame = new JFrame("Tic Tac Toe");
    JButton[][] buttons = new JButton[3][3];
    char currentPlayer = 'X';

    public TicTacToeGUI() {
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeButtons();

        frame.setVisible(true);
    }

    void initializeButtons() {
        Font font = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);

                int row = i;
                int col = j;

                buttons[i][j].addActionListener(e -> {
                    if (buttons[row][col].getText().equals("")) {
                        buttons[row][col].setText(String.valueOf(currentPlayer));

                        if (checkWinner()) {
                            JOptionPane.showMessageDialog(frame, currentPlayer + " wins!");
                            resetGame();
                        } else if (isDraw()) {
                            JOptionPane.showMessageDialog(frame, "Draw!");
                            resetGame();
                        }

                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                });

                frame.add(buttons[i][j]);
            }
        }
    }

    boolean checkWinner() {
        String p = String.valueOf(currentPlayer);

        // rows & columns
        for (int i = 0; i < 3; i++) {
            if ((buttons[i][0].getText().equals(p) &&
                 buttons[i][1].getText().equals(p) &&
                 buttons[i][2].getText().equals(p)) ||
                (buttons[0][i].getText().equals(p) &&
                 buttons[1][i].getText().equals(p) &&
                 buttons[2][i].getText().equals(p))) {
                return true;
            }
        }

        // diagonals
        if ((buttons[0][0].getText().equals(p) &&
             buttons[1][1].getText().equals(p) &&
             buttons[2][2].getText().equals(p)) ||
            (buttons[0][2].getText().equals(p) &&
             buttons[1][1].getText().equals(p) &&
             buttons[2][0].getText().equals(p))) {
            return true;
        }

        return false;
    }

    boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
