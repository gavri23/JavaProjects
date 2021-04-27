import javax.swing.*;
import java.security.SecureRandom;
public class LifeBoard extends JPanel{

        private  int[][] board;

        public LifeBoard(int size) {
            board =new int[size][size];
            fillBoard();
        }

        //This function return the board as two dimensional array.
        public int [] [] getBoard() {
            return board;
        }

        //This function fill giving board in random values of 0 and 1.
        public void fillBoard() {
            SecureRandom randomNumbers = new SecureRandom();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board.length; j++) {
                    int random = randomNumbers.nextInt(2);
                    board[i][j] = random;
                }
            }
        }

        //This function changes the values of the giving board according to "Game of life".
        public  void changeBoard() {
            int[][] newBoard = new int[board.length][board.length];
            int aliveNeighbors = 0;
            for(int i = 0; i< board.length; i++) {
                for(int j = 0; j< board.length; j++) {
                    if(i != 0 && i != board.length-1 && j!=0 && j!= board.length-1) { //in the middle
                        aliveNeighbors = board[i-1][j-1] + board[i][j-1] + board[i+1][j-1] + board[i-1][j] + board[i+1][j] + board[i-1][j+1] + board[i][j+1] + board[i+1][j+1];
                    } else {  //edges
                        if(i == 0) { //left column
                            if(j == 0) { //top left corner
                                aliveNeighbors = board[i][j+1] + board[i+1][j+1] + board[i+1][j];
                            } else if(j == board.length-1) {  //bottom left corner
                                aliveNeighbors = board[i][j-1] + board[i+1][j-1] + board[i+1][j];
                            } else { //middle of the left column
                                aliveNeighbors = board[i][j-1] + board[i][j+1] + board[i+1][j-1]  + board[i+1][j] + board[i+1][j+1];
                            }
                        } else if(i == board.length-1) {//right column
                            if(j == 0) { //top right corner
                                aliveNeighbors = board[i][j + 1] + board[i - 1][j] + board[i - 1][j + 1];
                            }
                            else if(j == board.length-1) //bottom right corner
                            {
                                aliveNeighbors = board[i-1][j] + board[i-1][j-1] + board[i][j-1];
                            }
                            else //middle of the right column
                            {
                                aliveNeighbors = board[i][j-1] + board[i][j+1] + board[i-1][j-1]  + board[i-1][j] + board[i-1][j+1];
                            }
                        }
                        else //middle tiles of the edge
                        {
                            if(j == 0){ //middle of the top row
                                aliveNeighbors = board[i-1][j] + board[i+1][j] + board[i][j+1]  + board[i-1][j+1] + board[i+1][j+1];
                            } else if(j == board.length-1) { //middle of bottom row
                                aliveNeighbors = board[i-1][j] + board[i+1][j] + board[i-1][j-1]  + board[i][j-1] + board[i+1][j-1];
                            }
                        }
                    }
                    newBoard[i][j] = paintTile(aliveNeighbors, board[i][j]);
                }//End of second for loop
            }//End of first for loop
            board =newBoard;
        }

        public int paintTile ( int aliveNeighbors, int currentTile){
            if (currentTile == 0){
                return (aliveNeighbors == 3) ? 1 : 0;
            }else {
                return (aliveNeighbors < 2 || aliveNeighbors > 3) ? 0 : 1 ;
            }
        } //End of paintTile
    }




