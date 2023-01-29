package sudokurevised;

public interface GameLevel {
    //Strategy design pattern class

    public void easyLevel(int[][] numbers, boolean[][] isGiven);
    public void hardLevel(int[][] numbers, boolean[][] isGiven);
}
