import java.util.Scanner;
/**
 * Models a Scanner object that analyzes numbers
 * @author Diljot
 */
public class AnalyzingNumbers
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter two doubles (like this: 41.7 -22.5): ");
        double input1 = scan.nextDouble();
        double input2= scan.nextDouble();
        // print statement only executes if the given condition is met
        if (input2 > 100)
        {
            System.out.println("The second number is greater than 100");
        }
        if (input1 == (int)input1)
        {
            System.out.println("The first number is an integer"); 

        }
        if (input1 != (int)input1)
        {
            System.out.println("The first number is an not an integer");

        }
        if (input1 == input2)
        {
            System.out.println("The numbers are equal");
        }
        if (input1 > input2)
        {
            System.out.println("The first number is larger");
        }
        if (input2 > input1)
        {
            System.out.println("The second number is larger");
        }
        if (input1 > 0 && input2 > 0 || (input1 < 0 && input2 < 0))
        {
            System.out.println("The numbers have the same sign");

        }
        if (!(input1 > 0 && input2 > 0 || (input1 < 0 && input2 < 0)))
        {
            System.out.println("The numbers have different signs");
        }
    }
}
