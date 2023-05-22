import java.util.Random;

public class Board {
    private Cell[][] cells;
    private int numRows, numCols, numMines;

    public Board(int numRows, int numCols, int numMines) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.numMines = numMines;
        cells = new Cell[numRows][numCols];
        initialize();
        placeMines();
        calculateNeighboringMines();
    }

    private void initialize() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int numMinesPlaced = 0;
        while (numMinesPlaced < numMines) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numCols);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                numMinesPlaced++;
            }
        }
    }

    private void calculateNeighboringMines() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (!cells[row][col].isMine()) {
                    int neighboringMines = 0;
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (i >= 0 && i < numRows && j >= 0 && j < numCols && cells[i][j].isMine()) {
                                neighboringMines++;
                            }
                        }
                    }
                    cells[row][col].setNeighboringMines(neighboringMines);
                }
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumMines() {
        return numMines;
    }
}