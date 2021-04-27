import java.util.Scanner;
import java.util.Random;

public class guessGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randGuess = new Random();
        int guesses = 0;
        int chosenNum = randGuess.nextInt(10) + 1;

        int guess;
        boolean win = false;

        System.out.println("Guess a number between 1 & 10");

        while (!win) {
            guess = scan.nextInt();
            guesses++;

            if (guess == chosenNum)
                win = true;
            else if (guess < chosenNum)
                System.out.println("Guess higher");
            else if (guess > chosenNum)
                System.out.println("Guess lower");


        }
        System.out.println("Congratulations! you have guessed right");
        System.out.println("Your number of tries is" + " " +guesses);

    }

}


