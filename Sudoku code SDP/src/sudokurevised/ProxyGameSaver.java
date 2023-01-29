package sudokurevised;

import java.io.File;

public class ProxyGameSaver implements InterfaceGameSaver {
    private String fileName;
    private String level;
    GameBoardPanel gameBoardPanel = new GameBoardPanel();
    private GameSaver game;

    public ProxyGameSaver(String name, String level) {
        fileName = name;
        this.level = level;
    }

    @Override
    public boolean save(GameBoardPanel gameBoard) {
        File gameFile = new File(fileName + "_" + level + ".txt");
        if (gameFile.exists() == false || getSavedGame() == null) {
            game = new GameSaver(fileName, level);
        }
        return game.save(gameBoard);
    }

    @Override
    public boolean hasSaveGame() {
        File gameFile = new File(fileName + "_" + level + ".txt");
        if (gameFile.exists()) {
            game = new GameSaver(fileName, level);
            return game.hasSaveGame();
        }
        return false;
    }

    @Override
    public GameBoardPanel getSavedGame() {
        File gameFile = new File(fileName + "_" + level + ".txt");
        if (gameFile.exists()) {
            game = new GameSaver(fileName, level);
            return game.getSavedGame();
        }
        return null;
    }
}
