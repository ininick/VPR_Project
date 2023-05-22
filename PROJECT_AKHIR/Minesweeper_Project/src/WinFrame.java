import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame {
    public WinFrame() {
        JLabel label = new JLabel("You Reveal all the Bomb! You Won!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}