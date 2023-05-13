import javax.swing.*;

public class GameBoard extends JButton {
    private int row;
    private int col;
    private boolean isMine;
    private boolean isFlagged;
    private boolean isRevealed;

    public GameBoard(int row, int col) {
        this.row = row;
        this.col = col;
        this.isMine = false;
        this.isFlagged = false;
        this.isRevealed = false;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isMine() {
        return isMine;
    }
    
    public void setMine(boolean mine) {
        isMine = mine;
    }
    
    public boolean isFlagged() {
        return isFlagged;
    }
    
    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }
    
    public boolean isRevealed() {
        return isRevealed;
    }
    
    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }
    
    public void setNumber(int num) {
        setText(String.valueOf(num));
    }
    
    public void setBomb() {
        setText("B");
    }
    
    public void setFlag() {
        setText("F");
    }
    
}
