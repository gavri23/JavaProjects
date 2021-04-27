import java.util.*;

public class Tester {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to our shop \"Make Polynoms\"");
        System.out.println("Please build your first Polynom");
        Polynom p1 = GetInput();
        System.out.println("Please build your second Polynom");
        Polynom p2 = GetInput();
        test(p1,p2);
    }
    public static void powersSort(int[] a) {
        Arrays.sort(a);
        int temp;
        for(int i = 0;i<a.length/2;i++){
            temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
    }
    public static void test(Polynom p1, Polynom p2)
    {
        System.out.print("The first polynom p1 is: ");
        System.out.println(p1.toString());
        System.out.print("The second polynom p2 is ");
        System.out.println(p2.toString());
        System.out.println();
        System.out.println("Lets check if p1 and p2 are equal:");
        if (p1.equals(p2)) {
            System.out.println( "p1 and p2 are equal\n");
        } else {
            System.out.println( "p1 and p2 are not equal\n");
        }
        System.out.println("Lets check what is the result of p1 plus p2:");
        Polynom p3 = new Polynom();
        p3 = p3.plus(p2,p1);
        System.out.println(p3.toString());
        Polynom p4 = new Polynom();
        System.out.println("Lets check what is the result of p1 minus p2:");
        p4 = p4.minus(p1,p2);
        System.out.println(p4.toString());
        System.out.println("Lets check what is the derivative of p1:");
        p1.derivative(p1);
        System.out.println(p1.toString());
        System.out.println("Lets check what is the derivative of p2:");
        p2.derivative(p2);
        System.out.println(p2.toString());
    }

    public static Polynom GetInput() throws Exception {
        Scanner numsCount = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();
        System.out.println("Enter polynom coefficients:");
        Scanner numScanner = new Scanner(numsCount.nextLine());
            int counterCoefs= 0;
            while(numScanner.hasNextDouble()) {
                counterCoefs++;
                numbers.add(numScanner.nextDouble());
            }
        double[] coefficient = new double[counterCoefs];
        for(int i = 0; i < counterCoefs; i++)
            coefficient[i] = numbers.get(i);
        System.out.println("Enter polynom powers:");
        Scanner squareScanner = new Scanner(numsCount.nextLine());
        int counterPowers = 0;
        while(squareScanner.hasNextInt()){
            counterPowers++;
            powers.add(squareScanner.nextInt());
        }
        int[] power = new int[counterPowers];
        for (int i = 0; i < counterPowers; i++)
                power[i] = powers.get(i);
        powersSort(power);
        Polynom pol = new Polynom(power, coefficient);
        return pol;
    }
}

