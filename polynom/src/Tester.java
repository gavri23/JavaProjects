import java.util.Scanner;
public class Tester {
        public static void main(String[] args) {
            Polynom p1 = GetInput();
            Polynom p2 = GetInput();
            print(p1,p2);
        }
        public static void print(Polynom p1, Polynom p2)
        {
            System.out.println("The first polynom p1 is  (" + p1 + ")");
            System.out.println("The second polynom p2 is  (" + p2 + ")\n");

            System.out.println("Lets check if p1 and p2 are equals:");
            if (p1.equals(p2)) {
                System.out.println( p1+ " and " +p2 +" are equals\n");
            } else {
                System.out.println( p1+ "and" +p2 +" are  not equals\n");
            }

            System.out.println("Lets check what is the result of p1 plus p2:");
            Polynom p3 = p1.Plus(p2);
            System.out.println("(" + p1 + ") + (" + p2 + ") = " + p3 + "\n");

            System.out.println("Lets check what is the result of p1 minus p2:");
            Polynom p4 = p1.Minus(p2);
            System.out.println("(" + p1 + ") - (" + p2 + ") = " + p4 + "\n");

            System.out.println("Lets check what is the cut of p1:");
            Polynom p5 = p1.Cut();
            System.out.println("Cut of " + p1 + " is: " + p5 + "\n");

            System.out.println("Lets check what is the cut of p2:");
            Polynom p6 = p2.Cut();
            System.out.println("Cut of " + p2 + " is: " + p6);
        }



        public static Polynom GetInput() {
            Scanner numsCount = new Scanner(System.in);
            System.out.println("Enter polynom size:");
            int count = numsCount.nextInt();
            numsCount.nextLine(); // throw away the newline.
            double[] coefficient = new double[count];
            System.out.println("Enter polynom coefficients:");
            Scanner numScanner = new Scanner(numsCount.nextLine());
            for (int i = 0; i < count; i++) {
                if (numScanner.hasNextInt()) {
                    coefficient[i] = numScanner.nextInt();
                } else {
                    System.out.println("You didn't provide enough coefficients");
                    System.exit(1);
                }
            }
            int[] powers = new int[count];
            System.out.println("Enter polynom powers:");
            Scanner squareScanner = new Scanner(numsCount.nextLine());
            for (int i = 0; i < count; i++) {
                if (squareScanner.hasNextInt()) {
                    powers[i] = squareScanner.nextInt();
                } else {
                    System.out.println("You didn't provide enough powers");
                    System.exit(1);
                }
            }
            try {
                return new Polynom(coefficient, powers);
            } catch (Exception ex) {
                System.exit(1);
                return null;
            }
        }
    }


