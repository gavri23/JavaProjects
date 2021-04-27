import javax.swing.*;
public class LifeGame {
        public static void main(String[] args) {
            final int frameSize =500;

            JFrame frame = new JFrame("Game Of Life");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(frameSize, frameSize);

            Panel p = new Panel();
            frame.add(p);// adding the panel to the jframe
            frame.setVisible(true);

            //play until user press on "no" or "cancel" buttons
            while (JOptionPane.showConfirmDialog(null, "Do you want to move to the next generation? \n") == 0) {
                p.nextGeneration();
                p.repaint();
            }//End of while loop
        }// End of while main
    }//End of main



