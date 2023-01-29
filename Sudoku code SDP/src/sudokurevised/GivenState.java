package sudokurevised;
import java.awt.*;
public class GivenState implements State{
    public static final Color BG_GIVEN = new Color(240, 240, 240); // RGB
    public static final Color FG_GIVEN = Color.BLACK;

    @Override
    public void paintCell(Cell cell) {
       int number = cell.number;
       cell.setText(number + "");
       cell.setEditable(false);
       cell.setBackground(BG_GIVEN);
       cell.setForeground(FG_GIVEN);
    }
    
}
