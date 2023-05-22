import javax.swing.JFrame;

public class MainGUI {
    public static void main(String[] args) {
        Game game = new Game(10, 10, 10);
        MinesweeperFrame frame = new MinesweeperFrame(game);
        JFrame frame2 = new JFrame("Minesweeper");
        frame.add(frame);
        // game.setFrame(frame);
    }
}