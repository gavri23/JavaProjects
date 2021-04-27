import java.util.Scanner;


public class maman11 {

    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello Evyatar, please enter your first triangle X coordinates");
        System.out.println("enter your first coordinate");
        double x11 = scan.nextInt();
        System.out.println("enter your second coordinate");
        double x12 = scan.nextInt();
        System.out.println("enter your first coordinate");
        double x13 = scan.nextInt();

        System.out.println("now, please enter your second triangle Y coordinates");
        System.out.println("enter your first coordinate");
        double y11 = scan.nextInt();
        System.out.println("enter your first coordinate");
        double y12 = scan.nextInt();
        System.out.println("enter your first coordinate");
        double y13 = scan.nextInt();
        double triLengthFirstLine = Math.sqrt((Math.pow((x11-x12),2.0) + (Math.pow((y11-y12),2.0))));
        double triLengthSecondLine = Math.sqrt((Math.pow((x11-x13),2.0) + (Math.pow((y11-y13),2.0))));
        double triLengthThirdLine = Math.sqrt((Math.pow((x12-x13),2.0) + (Math.pow((y12-y13),2.0))));


    }
}




