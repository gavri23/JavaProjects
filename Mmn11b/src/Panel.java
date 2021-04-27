import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private LifeBoard board;
    final private int rectSize = 30;
    final private int boardSize = 10;
    /*constructor*/
    public Panel() {
        board = new LifeBoard(boardSize);
    }
    /*this method goes to the next generation*/
    public void nextGeneration() {
        board.changeBoard();
    }

    /*this function paints the squares of board*/
    public void paintComponent(Graphics g) {
        int x=0,y=0; //coordinates of the board starting at the left top of the board
        super.paintComponent(g);
        int [][] gameBoard= board.getBoard();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (gameBoard[i][j] == 1) {
                    g.fillRect(x, y, rectSize, rectSize);
                } else {
                    g.drawRect(x, y, rectSize, rectSize);
                }
                x += rectSize;
            }
            y += rectSize; // going to the next line downwards
            x = 0; //starting at the first square in the new line downwards
        }
    }// End of paintComponent
} //End of Panel
