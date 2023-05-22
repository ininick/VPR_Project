import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinesweeperPanel extends JPanel {
    private Game game;
    private JButton[][] buttons;

    public MinesweeperPanel(Game game) {
        this.game = game;
        int numRows = game.getNumRows();
        int numCols = game.getNumCols();
        buttons = new JButton[numRows][numCols];
        setLayout(new GridLayout(numRows, numCols));
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.addMouseListener(new CellMouseListener(row, col));
                buttons[row][col] = button;
                add(button);
            }
        }

    }
    private class CellMouseListener extends MouseAdapter {
        private int row, col;

        public CellMouseListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                game.revealCell(row, col);
                refreshButtons();
            } else if (SwingUtilities.isRightMouseButton(e)) {
                game.flagCell(row, col);
                refreshButtons();
            }
        }
    }

    private void refreshButtons() {
        int numRows = game.getNumRows();
        int numCols = game.getNumCols();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = game.getCell(row, col);
                JButton button = buttons[row][col];
                if (cell.isRevealed()) {
                    if (cell.isMine()) {
                        button.setText("X");
                        button.setEnabled(false);
                    } else {
                        button.setText(Integer.toString(cell.getNeighboringMines()));
                        button.setEnabled(false);
                    }
                } else if (cell.isFlagged()) {
                    button.setText("F");
                } else {
                    button.setText("");
                }
                int countt = 0;
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++){
                        if(game.getCell(i,j).isFlagged()){
                            countt = countt + 1;
                        }
                    }
                }
                if(countt == game.getNumMines()){
                    WinFrame winFrame = new WinFrame();
                }
            }
        }
        
        // game.isGameOver();
        // WinFrame winFrame = new WinFrame();
    }
}