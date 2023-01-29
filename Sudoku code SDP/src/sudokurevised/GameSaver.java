package sudokurevised;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaver implements InterfaceGameSaver {
    private String fileName;
    private String level;
    GameBoardPanel gameBoardPanel = new GameBoardPanel();

    public GameSaver(String name, String level) {
        fileName = name;
        this.level = level;
    }

    @Override
    public boolean save(GameBoardPanel gameBoard){
        try {
            File gameFile = new File(fileName + "_" + level + ".txt");
            try (FileOutputStream fos = new FileOutputStream(gameFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(gameBoard);
                oos.flush();
                return true;
            }
        } catch (Exception e) {
            System.out.println("File Could not be saved");
            return false;
        }
    }

    @Override
    public boolean hasSaveGame() {
        File gameFile = new File(fileName + "_" + level + ".txt");
            try{
            return gameFile.exists();
        } catch (Exception e) {
            return false;
            }
    }

    @Override
    public GameBoardPanel getSavedGame() {

        File gameFile = new File(fileName + "_" + level + ".txt");
        try {
            // file input stream used to read image data
            try (FileInputStream fis = new FileInputStream(gameFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                GameBoardPanel board = (GameBoardPanel) ois.readObject();
                board.setListener();
                board.setScore();
                return board;
            }
        } catch (Exception e) {
            System.out.println("Error loading game");
            return null;
        }
    }
}
