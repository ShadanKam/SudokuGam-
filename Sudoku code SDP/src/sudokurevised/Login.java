package sudokurevised;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login implements ActionListener {

    private static JFrame username = new JFrame();
    private static JFrame helpFrame = new JFrame();
    private static JFrame resumeGame = new JFrame();
    private static JPanel panel3 = new JPanel();
    private static JPanel panel4 = new JPanel();
    private static JPanel panel = new JPanel();
    private static JLabel user = new JLabel("Username:");
    private static JTextField userText = new JTextField();
    private static JButton next = new JButton("Next");
    private static JButton play = new JButton("Play");
    private static JButton help = new JButton("Help");
    private static JFrame levels = new JFrame();
    private static JPanel panel2 = new JPanel();
    private static JButton easy = new JButton("Easy");
    private static JButton hard = new JButton("Hard");
    private static JButton back = new JButton("Back");
    private static JButton back2 = new JButton("Back");
    private static JButton newGame = new JButton("New Game");
    private static JButton oldGame = new JButton("Old Game");

    public Login() {
        loginFrame();
        levelsFrame();
        actionPerformed(null);
    } // constructor

    public static void loginFrame() {

        // setting username fram size which contains username and 1-next 2-play 3-help
        username.setSize(500, 500);
        username.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting panel layout and adding it to frame
        panel.setLayout(null);
        username.add(panel);

        // setting "username" label and adding it to panel
        user.setBounds(110, 70, 80, 20);
        panel.add(user);

        // setting user textfield and adding it to panel
        userText.setBounds(180, 70, 145, 20);
        panel.add(userText);

        // next button which validates user input
        next.setBounds(210, 110, 80, 20);
        panel.add(next);

        // play button which leads user to 'hard' & 'easy' levels
        play.setBounds(155, 200, 80, 20);
        panel.add(play);

        // help button which shows the user instructions to play the game
        help.setBounds(270, 200, 80, 20);
        panel.add(help);

        // disabling these two buttons until the user enters a valid username
        play.setEnabled(false);
        help.setEnabled(false);

        username.setVisible(true);

        // the method that will lead the player to the levels frame when 'play button'
        // is clicked
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                username.setVisible(false); // Hide current frame
                levels.setVisible(true); // Hide current frame
            }
        });

        // the method that will lead the player to the levels frame when 'play button'
        // is clicked
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                username.setVisible(false); // Hide current frame
                helpFrame();
            }
        });
    }

    public static void levelsFrame() {

        // setting levels frame size which contains 1-easy 2-hard 3-back
        levels.setSize(500, 500);
        levels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding panel 2 to the levels frame and setting the layout
        levels.add(panel2);
        panel2.setLayout(null);

        // easy button which will lead to the easy sudoku puzzle
        easy.setBounds(155, 200, 80, 20);
        panel2.add(easy);

        // hard button which will lead to the hard sudoku puzzle
        hard.setBounds(270, 200, 80, 20);
        panel2.add(hard);

        // back button which will take the user back to username frame
        back.setBounds(155, 300, 80, 20);
        panel2.add(back);

        // back button which will take the user back to username frame
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                levels.dispose();
                username.setVisible(true);

            }
        });

        // the methods that will lead the player to the level they chose
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GameBoardPanel gameBoardPanel = new GameBoardPanel();
                if (hasSavedGame(userText.getText(), "1", gameBoardPanel.score)) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "You have existing game. Would you like to continue?",
                            "alert", JOptionPane.OK_CANCEL_OPTION);

                    if (result == 0) {
                        loadGame("1");
                        return;
                    }
                }
                levels.setVisible(false);
                new SudokuMain(1, userText.getText());
            }
        });

        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GameBoardPanel gameBoardPanel = new GameBoardPanel();
                if (hasSavedGame(userText.getText(), "2", gameBoardPanel.score)) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "You have existing game. Would you like to continue?",
                            "alert", JOptionPane.OK_CANCEL_OPTION);

                    if (result == 0) {
                        loadGame("2");
                        return;
                    }
                }
                levels.setVisible(false);
                new SudokuMain(2, userText.getText());
            }
        });
    }

    public static void loadGame(String level) {
        new SudokuMain().loadGame(userText.getText(), level);
    }

    public static boolean hasSavedGame(String username, String level, int score) {
        InterfaceGameSaver gameSaver = new ProxyGameSaver(username, level);
        return gameSaver.hasSaveGame();
    }

    public static void helpFrame() {

        // help frame set size
        helpFrame.setSize(500, 500);
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding panel 3 to the help frame and setting the layout
        helpFrame.add(panel3);
        panel3.setLayout(null);

        // back button which will take the user back to username frame
        back2.setBounds(200, 300, 80, 20);
        panel3.add(back2);

        back2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                helpFrame.dispose();
                username.setVisible(true);

            }
        });

        // label which contains the instructions
        String instruct = "Sudoku is played on a grid of 9 x 9 spaces.<br>" +
                "Within the rows and columns are 9 “squares” (made up of 3 x 3 spaces).<br>" +
                "Each row, column and square (9 spaces each) needs to be filled out with the numbers 1-9,<br>" +
                "without repeating any numbers within the row, column or square.<br>" +
                "each Sudoku grid comes with a few spaces already filled in;<br>" +
                "the more spaces filled in, the easier the game – <br>" +
                "the more difficult Sudoku puzzles have very few spaces that are already filled in.";

        // label which contains the instructions
        JLabel instructions = new JLabel("<html>" + instruct + "</html>");
        instructions.setBounds(10, 70, 500, 150);
        panel3.add(instructions);

        helpFrame.setVisible(true);
    }

    public static void resumeGame() {
        // frame that asks exisisting users if they want to continue old games

        /*
         * THIS FUNCTION will be called inside the easy - hard
         * buttons with validation if the user exists, resume game
         */
        resumeGame.setSize(500, 500);
        resumeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding panel 4 to the resume game and setting the layout
        resumeGame.add(panel4);
        panel4.setLayout(null);

        // create a message asking what do they want
        // create two buttons one that leads to a new game and another that leads to an
        // existing game
        newGame.setBounds(155, 200, 80, 20);
        panel4.add(newGame);

        oldGame.setBounds(270, 200, 80, 20);
        panel4.add(oldGame);

        // action inside the buttons to either create a new game or go back to existing
        // one
    }

    public static boolean validateUser() {
        // this method validates if the textfield contains anything other than alphabet
        if (userText.getText().matches("[A-Za-z]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateUserLength() {
        // this method validates if the user entered more or less than 3-8
        if (userText.getText().length() >= 3 && userText.getText().length() <= 8) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // the method which will perform an action when 'next button' is clicked
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (userText.getText().equals("")) {
                    showMessageDialog(null, "Please fill in your Username",
                            "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else if (!validateUser()) {
                    showMessageDialog(null, "Username must only contain alphabets",
                            "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else if (!validateUserLength()) {
                    showMessageDialog(null, "Username can't be less than 3 or more than 8",
                            "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else {

                    play.setEnabled(true);
                    help.setEnabled(true);

                }

            }

        });

    }

}
