package sudokurevised;

public interface InterfaceGameSaver {

    public boolean save(GameBoardPanel gameBoard);
    
    public boolean hasSaveGame();

    public GameBoardPanel getSavedGame();
}
