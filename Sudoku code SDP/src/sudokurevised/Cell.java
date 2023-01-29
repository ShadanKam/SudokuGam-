package sudokurevised;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * The Cell class model the cells of the Sudoku puzzle, by customizing
 * (subclass)
 * the javax.swing.JTextField to include row/column, puzzle number and status.
 */
public class Cell extends JTextField{
   private static final long serialVersionUID = 1L; // to prevent serial warning

   // Define named constants for JTextField's colors and fonts
   // to be chosen based on CellStatus
   public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

   // Define properties (package-visible)
   /** The row and column number [0-8] of this cell */
   int row, col;
   /** The puzzle number [1-9] for this cell */
   int number;
   /** The status of this cell defined in enum CellStatus */
   CellStatus status;

   /** Constructor */
   public Cell(int row, int col) {
      super(); // JTextField
      this.row = row;
      this.col = col;
      // Inherited from JTextField: Beautify all the cells once for all
      super.setHorizontalAlignment(JTextField.CENTER);
      super.setFont(FONT_NUMBERS);
   }

   /** Reset this cell for a new game, given the puzzle number and isGiven */
   public void newGame(int number, boolean isGiven) {
      this.number = number;
      status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
      paint(); // paint itself
   }

   /** This Cell (JTextField) paints itself based on its status */
   public void paint() {
      if (status == CellStatus.GIVEN) {
          GivenState gState=new GivenState();
          gState.paintCell(this);
          
         // Inherited from JTextField: Set display properties
      } else if (status == CellStatus.TO_GUESS) {
          NotGivenState nState =new NotGivenState();
          nState.paintCell(this);
         
         // Inherited from JTextField: Set display properties
      } else if (status == CellStatus.CORRECT_GUESS) { // from TO_GUESS
          CorrectState cState=new CorrectState();
          cState.paintCell(this);
         
      } else if (status == CellStatus.WRONG_GUESS) { // from TO_GUESS
          WrongState wsState=new WrongState();
          wsState.paintCell(this);
          
      }
   }
}
