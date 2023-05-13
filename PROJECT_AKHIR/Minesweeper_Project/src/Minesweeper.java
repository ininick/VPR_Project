import javax.swing.*;

public class Minesweeper{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minesweeper");
        SettingsFrame settingsFrame = new SettingsFrame();

        frame.add(frame, settingsFrame, 0);
    }
}
