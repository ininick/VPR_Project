import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener {
    private JTextField rowsField;
    private JTextField colsField;
    private JTextField numMinesField;

    public SettingsFrame() {
        setTitle("Minesweeper Game!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Rows:"));
        rowsField = new JTextField("");
        rowsField.setPreferredSize(new Dimension(150, 20));
        panel.add(rowsField);
        panel.add(new JLabel("Columns:"));
        colsField = new JTextField("");
        colsField.setPreferredSize(new Dimension(150, 20));
        panel.add(colsField);
        panel.add(new JLabel("Number of Mines:"));
        numMinesField = new JTextField("");
        numMinesField.setPreferredSize(new Dimension(150, 20));
        panel.add(numMinesField);

        JButton startButton = new JButton("Start Game");
        startButton.setPreferredSize(new Dimension(120, 20));
        startButton.addActionListener(this);
        panel.add(startButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(120, 20));
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start Game")) {
            try {
                int rows = Integer.parseInt(rowsField.getText());
                int cols = Integer.parseInt(colsField.getText());
                int numMines = Integer.parseInt(numMinesField.getText());
                GameFrame gameFrame = new GameFrame(rows, cols, numMines);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            dispose();
        }
    }
}

