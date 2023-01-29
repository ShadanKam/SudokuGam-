package sudokurevised;

import java.awt.*;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {

    private static final long serialVersionUID = 1L; // to prevent serial warning
    GameBoardPanel gameBoardPanel = new GameBoardPanel();

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {

    }
    public void loadGame(String user, String level) {

        InterfaceGameSaver gameSaver = new ProxyGameSaver(user, level);
        board = gameSaver.getSavedGame();

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(board, BorderLayout.CENTER);
        savedialog(gameSaver);
        cp.add(GameBoardPanel.userscorelabel, BorderLayout.PAGE_START); //add the score label to the board
        pack(); // Pack the UI components, instead of using setSize()
        setTitle("Sudoku");
        setVisible(true);
    }

    public SudokuMain(int level, String user) {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(board, BorderLayout.CENTER);
        InterfaceGameSaver gameSaver = new ProxyGameSaver(user, String.valueOf(level));
        savedialog(gameSaver);
        cp.add(GameBoardPanel.userscorelabel, BorderLayout.PAGE_START); //add the score label to the board 
        // Initialize the game board to start the game
        board.newGame(level);
        pack(); // Pack the UI components, instead of using setSize()
        // save?
        setTitle("Sudoku");
        setVisible(true);
    }

    public void savedialog(InterfaceGameSaver gameSaver) {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {

                int selectedOption = JOptionPane.showConfirmDialog(null,
                    "Do you want to save the game?",
                    "Choose",
                    JOptionPane.YES_NO_CANCEL_OPTION);

                if (selectedOption == JOptionPane.YES_OPTION) {

                    if (gameSaver.save(board)) {

                        JOptionPane.showMessageDialog(null, "Game was saved\n" + "Your Score is:" + board.score);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Game could not be saved!");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }

                } else if (selectedOption == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Game was not saved!");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } else if (selectedOption == JOptionPane.CANCEL_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }

            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}