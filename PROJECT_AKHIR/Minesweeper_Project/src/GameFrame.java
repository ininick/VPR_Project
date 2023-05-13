import javax.swing.*;

public class GameFrame extends JFrame {
    private Board board;

    public GameFrame(int rows, int cols, int numMines) {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setResizable(true);
        
        board = new Board(rows, cols, numMines);
        board.placeMines();
        add(board);
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
