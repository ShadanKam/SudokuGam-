package sudokurevised;

public class HardLevel implements GameLevel {
public HardLevel(int[][] numbers, boolean[][] isGiven){
    hardLevel(numbers, isGiven);
}
    @Override
    public void easyLevel(int[][] numbers, boolean[][] isGiven){

    }
    @Override
    public void hardLevel(int[][] numbers, boolean[][] isGiven) {
        int[][] hardcodedNumbers =
                /* 1 */ { { 5, 9, 2, 4, 8, 7, 1, 6, 3 },
                        /* 2 */ { 6, 3, 4, 1, 5, 9, 7, 2, 8 },
                        /* 3 */ { 7, 1, 8, 2, 6, 3, 9, 4, 5 },
                        /* 4 */ { 3, 4, 7, 6, 1, 2, 8, 5, 9 },
                        /* 5 */ { 2, 5, 6, 3, 9, 8, 4, 7, 1 },
                        /* 6 */ { 1, 8, 9, 5, 7, 4, 6, 3, 2 },
                        /* 7 */ { 8, 2, 1, 7, 3, 6, 5, 9, 4 },
                        /* 8 */ { 9, 7, 3, 8, 4, 5, 2, 1, 6 },
                        /* 9 */ { 4, 6, 5, 9, 2, 1, 3, 8, 7 } };

        // Copy from hardcodedNumbers into the array "numbers"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Need to use input parameter cellsToGuess!
        // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
        boolean[][] hardcodedIsGiven =
                /* 1 */ { { true, false, false, false, true, false, true, false, false },
                        /* 2 */ { false, false, true, false, false, false, false, true, false },
                        /* 3 */ { true, false, true, true, false, false, false, true, false },
                        /* 4 */ { false, false, false, false, false, false, false, true, false },
                        /* 5 */ { false, true, false, true, false, false, false, false, true },
                        /* 6 */ { false, false, false, false, false, true, false, false, true },
                        /* 7 */ { true, false, true, false, false, true, true, false, false },
                        /* 8 */ { false, false, true, false, false, false, false, false, false },
                        /* 9 */ { true, false, false, false, false, true, true, false, true } };

        // Copy from hardcodedIsGiven into array "isGiven"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }

}
