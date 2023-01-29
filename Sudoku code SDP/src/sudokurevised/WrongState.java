package sudokurevised;
import java.awt.*;
public class WrongState implements State{
    public static final Color BG_WRONG_GUESS = new Color(216, 0, 0);

    @Override
    public void paintCell(Cell cell) {
       cell.setBackground(BG_WRONG_GUESS);
    }
    
}
