package sudokurevised;
import java.awt.*;
public class CorrectState implements State{

    public static final Color BG_CORRECT_GUESS = new Color(0, 216, 0);

    @Override
    public void paintCell(Cell cell) {
        cell.setBackground(BG_CORRECT_GUESS);  
    }

    
}
