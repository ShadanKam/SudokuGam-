package sudokurevised;

public class EasyLevel implements GameLevel {
    public EasyLevel(int[][] numbers, boolean[][] isGiven){
        easyLevel(numbers, isGiven);
    }
    @Override
    public void easyLevel(int[][] numbers, boolean[][] isGiven) {
        int[][] hardcodedNumbers =
                /* 1 */ { { 1, 2, 9, 4, 5, 3, 7, 8, 6 },
                        /* 2 */ { 3, 6, 4, 7, 2, 8, 5, 9, 1 },
                        /* 3 */ { 8, 7, 5, 9, 1, 6, 3, 2, 4 },
                        /* 4 */ { 7, 5, 2, 8, 9, 1, 6, 4, 3 },
                        /* 5 */ { 9, 1, 3, 5, 6, 4, 2, 7, 8 },
                        /* 6 */ { 4, 8, 6, 2, 3, 7, 9, 1, 5 },
                        /* 7 */ { 6, 9, 8, 3, 4, 2, 1, 5, 7 },
                        /* 8 */ { 5, 3, 7, 1, 8, 9, 4, 6, 2 },
                        /* 9 */ { 2, 4, 1, 6, 7, 5, 8, 3, 9 } };

        // Copy from hardcodedNumbers into the array "numbers"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Need to use input parameter cellsToGuess!
        // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
        boolean[][] hardcodedIsGiven =
                /* 1 */ { { false, true, true, false, true, false, false, false, true },
                        /* 2 */ { true, false, true, true, true, true, false, false, true },
                        /* 3 */ { false, false, false, false, false, false, true, false, false },
                        /* 4 */ { false, true, true, true, true, true, true, true, false },
                        /* 5 */ { false, true, true, false, true, true, true, true, false },
                        /* 6 */ { false, false, false, false, false, true, true, false, false },
                        /* 7 */ { false, true, false, false, false, false, true, true, true },
                        /* 8 */ { true, false, false, true, true, false, true, false, true },
                        /* 9 */ { false, false, false, false, false, false, true, true, false } };

        // Copy from hardcodedIsGiven into array "isGiven"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }
    @Override
    public void hardLevel(int[][] numbers, boolean[][] isGiven){

    }

}
