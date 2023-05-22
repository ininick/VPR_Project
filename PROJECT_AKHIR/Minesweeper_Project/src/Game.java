
public class Game {
    private Board board;
    private boolean isGameOver;

    public Game(int numRows, int numCols, int numMines) {
        board = new Board(numRows, numCols, numMines);
        isGameOver = false;
    }

    // public void play() {
    //     Scanner scanner = new Scanner(System.in);
    //     while (!isGameOver) {
    //         printBoard();
    //         System.out.print("Enter row and column to reveal or flag (e.g. 1 2 f): ");
    //         int row = scanner.nextInt() - 1;
    //         int col = scanner.nextInt() - 1;
    //         String action = scanner.next();
    //         if (action.equalsIgnoreCase("f")) {
    //             flagCell(row, col);
    //         } else {
    //             revealCell(row, col);
    //         }
    //         if (isGameWon()) {
                
    //             System.out.println("Congratulations, you won!");
    //             isGameOver = true;
    //         }
    //     }
    //     WinFrame winFrame = new WinFrame();
    //     printBoard();
    // }

    // private void printBoard() {
    //     System.out.print("   ");
    //     for (int col = 0; col < board.getNumCols(); col++) {
    //         System.out.print((col + 1) + " ");
    //     }
    //     System.out.println();
    //     System.out.print("  ");
    //     for (int col = 0; col < board.getNumCols(); col++) {
    //         System.out.print("--");
    //     }
    //     System.out.println();
    //     for (int row = 0; row < board.getNumRows(); row++) {
    //         System.out.print((row + 1) + "| ");
    //         for (int col = 0; col < board.getNumCols(); col++) {
    //             Cell cell = board.getCell(row, col);
    //             if (cell.isRevealed()) {
    //                 if (cell.isMine()) {
    //                     System.out.print("X ");
    //                 } else {
    //                     System.out.print(cell.getNeighboringMines() + " ");
    //                 }
    //             } else if (cell.isFlagged()) {
    //                 System.out.print("F ");
    //             } else {
    //                 System.out.print("?");
    //             }
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }

    public void flagCell(int row, int col) {
        Cell cell = board.getCell(row, col);
        if (!cell.isRevealed()) {
            cell.setFlagged(!cell.isFlagged());
        }
    }
    
    

    public void revealCell(int row, int col) {
        Cell cell = board.getCell(row, col);
        if (!cell.isFlagged()) {
            cell.setRevealed(true);
            if (cell.isMine()) {
                // System.out.println("Game over, you hit a mine!");
                GameOverFrame gameOver = new GameOverFrame();
                isGameOver = true;
            } else if (cell.getNeighboringMines() == 0) {
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i >= 0 && i < board.getNumRows() && j >= 0 && j < board.getNumCols() && !board.getCell(i, j).isRevealed()) {
                            revealCell(i, j);
                        }
                    }
                }
            }
        }
    }

    private boolean isGameWon() {
        for (int row = 0; row < board.getNumRows(); row++) {
            for (int col = 0; col < board.getNumCols(); col++) {
                Cell cell = board.getCell(row, col);
                if (!cell.isRevealed() && !cell.isMine()) {
                    return false;
                }
            }
        }
        // System.out.println("masuk");
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
    public Cell getCell(int row, int col) {
        return board.getCell(row, col);
    }

    public int getNumRows() {
        return board.getNumRows();
    }

    public int getNumCols() {
        return board.getNumCols();
    }

    public int getNumMines() {
        return board.getNumMines();
    }
}