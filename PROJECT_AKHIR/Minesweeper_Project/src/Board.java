import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    private int rows;
    private int cols;
    private int numMines;
    private GameBoard[][] cells;

    public Board(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.cells = new GameBoard[rows][cols];

        setLayout(new GridLayout(rows, cols));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                GameBoard cell = new GameBoard(row, col);
                cell.setPreferredSize(new Dimension(55, 55));
                cell.addActionListener(this);
                cells[row][col] = cell;
                add(cell);
            }
        }
    }

    // public void actionPerformed(ActionEvent e) {
    //     GameBoard cell = (GameBoard) e.getSource();
    //     int row = cell.getRow();
    //     int col = cell.getCol();
    //     if (!cell.isFlagged()) {
    //         if (cell.isMine()) {
    //             revealAllMines();
    //             JOptionPane.showMessageDialog(this, "Game Over!");
    //         } else {
    //             int numAdjacentMines = getNumAdjacentMines(row, col);
    //             if (numAdjacentMines == 0) {
    //                 revealEmptyCells(row, col);
    //             } else {
    //                 cell.setText(String.valueOf(numAdjacentMines));
    //             }
    //             cell.setRevealed(true);
    //             checkWin();
    //         }
    //     }
    // }

    public void actionPerformed(ActionEvent e) {
        GameBoard cell = (GameBoard) e.getSource();
        int row = cell.getRow();
        int col = cell.getCol();
        if (!cell.isFlagged()) {
            if (cell.isMine()) {
                cell.setBomb();
                revealAllMines();
                JOptionPane.showMessageDialog(this, "Game Over!");
            } else {
                int numAdjacentMines = getNumAdjacentMines(row, col);
                if (numAdjacentMines == 0) {
                    revealEmptyCells(row, col);
                } else {
                    cell.setNumber(numAdjacentMines);
                }
                cell.setRevealed(true);
                checkWin();
            }
        } else {
            cell.setFlag();
            cell.setFlagged(false);
        }
    }
    

    private int getNumAdjacentMines(int row, int col) {
        int numAdjacentMines = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols){
                    if (cells[r][c].isMine()) {
                        numAdjacentMines++;
                    }
                }
            }
        }
        return numAdjacentMines;
    }

    private void revealEmptyCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    GameBoard cell = cells[r][c];
                    if (!cell.isMine() && !cell.isRevealed()) {
                        int numAdjacentMines = getNumAdjacentMines(r, c);
                        if (numAdjacentMines == 0) {
                            cell.setText("");
                            cell.setRevealed(true);
                            revealEmptyCells(r, c);
                        } else {
                            cell.setText(String.valueOf(numAdjacentMines));
                            cell.setRevealed(true);
                        }
                    }
                }
            }
        }
    }

    private void revealAllMines() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                GameBoard cell = cells[row][col];
                if (cell.isMine()) {
                    cell.setText("X");
                    cell.setRevealed(true);
                }
            }
        }
    }

    private void checkWin() {
        int numRevealedCells = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                GameBoard cell = cells[row][col];
                if (cell.isRevealed()) {
                    numRevealedCells++;
                }
            }
        }
        int numCells = rows * cols;
        int numSafeCells = numCells - numMines;
        if (numRevealedCells == numSafeCells) {
            revealAllMines();
            JOptionPane.showMessageDialog(this, "You Win!");
        }
    }

    public void placeMines() {
        int numMinesPlaced = 0;
        while (numMinesPlaced < numMines) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                numMinesPlaced++;
            }
        }
    }
}
