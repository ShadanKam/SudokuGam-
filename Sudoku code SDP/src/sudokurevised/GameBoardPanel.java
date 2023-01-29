package sudokurevised;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoardPanel extends JPanel{
   private static final long serialVersionUID = 1L; // to prevent serial warning

   // Define named constants for the game board properties
   public static final int GRID_SIZE = 9; // Size of the board
   public static final int SUBGRID_SIZE = 3; // Size of the sub-grid
   public static final int CELL_SIZE = 60; // Cell width/height in pixels
   public static final int BOARD_WIDTH = CELL_SIZE * GRID_SIZE;
   public static final int BOARD_HEIGHT = CELL_SIZE * GRID_SIZE; 
   // Board width/height in pixels

   //score and its label 
   static JLabel userscorelabel = new JLabel();
   public int score=0;

   // Define properties
   /** The game board composes of 9x9 Cells (customized JTextFields) */
   private Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
   /** It also contains a Puzzle with array numbers and isGiven */

   private Puzzle puzzle = Puzzle.getpuzzle();//calling the puzzle by the puplic method not the constructer 
   private Puzzle puzzle2 = Puzzle.getpuzzle();//created a second object to check if the singleton method is working

   /** Constructor */
   public GameBoardPanel() {
      super.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE)); // JPanel

      // Allocate the 2D array of Cell, and added into JPanel.
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]); // JPanel
         }
      }

      CellInputListener listener = new CellInputListener();
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            if (cells[row][col].isEditable()) {
               cells[row][col].addActionListener(listener); // For all editable rows and cols
            }
         }
      }

      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

   }
   
   public void setListener(){

        CellInputListener listener = new CellInputListener();
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            if (cells[row][col].isEditable()) {
               cells[row][col].addActionListener(listener); // For all editable rows and cols
            }
         }
      }
   }
   public void setScore(){
       userscorelabel.setText(String.valueOf("Score "+score));
   }

   /**
    * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
    * You can call this method to start a new game.
    */
   public void newGame(int cellsToGuess) {
      // Generate a new puzzle
      puzzle.newPuzzle(cellsToGuess);

      // Initialize all the 9x9 cells, based on the puzzle.
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
         }
      }
   }

   /**
    * Return true if the puzzle is solved
    * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
    */
   public boolean isSolved() {
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
               return false;
            }
         }
      }
      return true;
   }

   private class CellInputListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // Get a reference of the JTextField that triggers this action event
         Cell sourceCell = (Cell) e.getSource();

         // Retrieve the int entered
         int numberIn = Integer.parseInt(sourceCell.getText());
         //
         // For debugging
         System.out.println("You entered " + numberIn);

         if (numberIn == sourceCell.number) {
            sourceCell.status = CellStatus.CORRECT_GUESS;
            score+=5;//increase by 5 if correct
         } else {
            sourceCell.status = CellStatus.WRONG_GUESS;
            //only positive values 
            if(score>1){
               score-=2;
             }
             else{
            //if score is nigative score =0 
             score=0;
             }
         }
         sourceCell.paint(); // re-paint this cell based on its status
         userscorelabel.setText("Score "+score);//add score value to the label
         System.out.println("Score"+score);//print the score
         if(isSolved()==true){
            JOptionPane.showMessageDialog(null, "Congratulation! your Score is" + String.valueOf(score));
         }

         //to check if the singleton class is working by checking hashcode is the same
         System.out.println(System.identityHashCode(puzzle));
         System.out.println(System.identityHashCode(puzzle2));

      }
   }
}