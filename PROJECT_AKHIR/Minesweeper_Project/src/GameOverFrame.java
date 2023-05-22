import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {
    public GameOverFrame() {
        JLabel label = new JLabel("You Hit the Bomb! Game Over!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}