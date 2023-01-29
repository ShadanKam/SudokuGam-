package sudokurevised;
import java.awt.*;
public class NotGivenState implements State{
    public static final Color FG_NOT_GIVEN = Color.GRAY;
    public static final Color BG_TO_GUESS = new Color(153, 211, 235);

    @Override
    public void paintCell(Cell cell) {
        cell.setText("");
        cell.setEditable(true);
        cell.setBackground(BG_TO_GUESS);
        cell.setForeground(FG_NOT_GIVEN);
    }
    
}
