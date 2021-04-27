import java.util.Scanner;

public class rockPaperScissors {
    public static Scanner scan = new Scanner(System.in);

    static int countw = 0;
    static int countl = 0;
    public static void main(String[] args) {
        rockPaprerScissorsGame();

    }

    private static void rockPaprerScissorsGame() {
        System.out.println("How many games would you like to play?");
        int gamesCompleted = 0;
        int numOfGames = scan.nextInt();

        while (gamesCompleted < numOfGames) {
            String userChoice = promptUserChoice();
            String computerChoice = promptcomputerChoice();
            printResults(userChoice, computerChoice);
            if (!userChoice.equals(computerChoice)) {
                gamesCompleted++;
            }

        }
        System.out.println("Total victories" + " " + countw + " " + "Total loses" + " " + countl);
        System.out.println("Thank you for playing!");
    }

    private static String promptcomputerChoice() {
        int computerChoice = (int) (3 * Math.random());
        if (computerChoice == 0)
            return "Rock";
        else if (computerChoice == 1)
            return "Paper";
        else//Scissors
            return "Scissors";
    }


    private static String promptUserChoice() {
        System.out.println("choose: 1 - Rock 2 - Paper 3 - Scissors");
        int userChoice = scan.nextInt();
        if (userChoice == 1)
            return "Rock";
        else if (userChoice == 2)
            return "Paper";
        else//Scissors
            return "Scissors";
    }

    private static void printResults(String userCoice, String computerChoice) {
        System.out.println("You chose       :" + userCoice);
        System.out.println("computer chose    :" + computerChoice);

        if (userCoice.equals("Rock")) {
            if (computerChoice.equals("Rock"))
                System.out.println("YOU TIED!!");
            else if (computerChoice.equals("Paper")) {
                System.out.println("YOU LOST!!");
                countl++;
            } else if (computerChoice.equals("Scissors")) {
                System.out.println("YOU WON!!");
                countw++;
            }
        } else if (userCoice.equals("Paper")) {
            if (computerChoice.equals("Paper"))
                System.out.println("YOU TIED!!");
            else if (computerChoice.equals("Scissors")) {
                System.out.println("YOU LOST!!");
                countl++;
            } else if (computerChoice.equals("Rock")){
                System.out.println("YOU WON!!");
                countw++;    }
        } else if (userCoice.equals("Scissors")) {
            if (computerChoice.equals("Scissors"))
                System.out.println("YOU TIED!!");
            else if (computerChoice.equals("Rock")) {
                System.out.println("YOU LOST!!");
                countl++;
            } else if (computerChoice.equals("Paper")) {
                System.out.println("YOU WON!!");
                countw++;
            }


        }

        System.out.println("_____________________________");

    }
}









