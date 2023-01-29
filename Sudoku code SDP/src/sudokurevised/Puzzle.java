package sudokurevised;

import java.io.Serializable;

/**
 * The Sudoku number puzzle to be solved
 */

public class Puzzle implements Serializable {

   // The numbers in the puzzle
   int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];

   // The clues, what numbers to show on board
   boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];

   /* Using Singleton design pattern */
   private static Puzzle singlepuzzle = null;

   // Constructor
   private Puzzle() {
   }

   // Singleton method create only one instance from the puzzle
   public static Puzzle getpuzzle() {

      if (singlepuzzle == null) {
         singlepuzzle = new Puzzle();
      }
      return singlepuzzle;

   }

   /*
    * Generate a new puzzle given the number of cells to be guessed,
    * which can be used to control the difficulty level.
    * This method shall set the array numbers and isGiven
    */

   public void newPuzzle(int cellsToGuess) {
      // I hardcode a puzzle here for illustration and testing.
      // if clause cellsToGuess is 34 == easy level, if 57 == hard level
      if (cellsToGuess == 1) {
         /* Using Strategy design pattern */
         new EasyLevel(numbers, isGiven);
      }

      // copy paste and change level.

      if (cellsToGuess == 2) {
         /* Using Strategy design pattern */
         new HardLevel(numbers, isGiven);

      }
   }

}