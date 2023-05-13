import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private boolean isMine;
    private boolean isRevealed;

    public Cell() {
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        setPreferredSize(new Dimension(30, 30));
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }
}
