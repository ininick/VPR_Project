import javax.swing.*;

public class MinesweeperFrame extends JFrame {
    private Game game;
    private MinesweeperPanel panel;

    public MinesweeperFrame(Game game) {
        this.game = game;
        panel = new MinesweeperPanel(game);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}