import java.util.Scanner;
/**
 * Models an application after the stock market 
 * @author Diljot Singh
 */
public class DJIA
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        double input = 0;
        double largest = 0;
        double sum = 0;
        int increaseAndDecreaseCount = 0;
        int count = 0;
        double average = 0;
        double previous = 0;

        // prompts user to enter the change for the day
        System.out.print("Enter the change for the day or Q to quit: ");
        if (scan.hasNextDouble() == false)
        {
            System.out.println("No values entered");
        }
        else
        {
            double input1 = scan.nextDouble();
            count++;
            increaseAndDecreaseCount++;
            sum = sum + input1;
            // intialize largest and previous
            largest = input1;
            previous = input1;
            //prompt
            System.out.print("Enter net income or Q to quit: ");
            // as long as there is a double input, checks inputs and prints them
            while (scan.hasNextDouble())
            {
                input = scan.nextDouble();
                previous = input;
                sum = sum + input;
                count++;

                if (input > largest)
                {
                    largest = input;
                }

                if (input > previous || input < 0)
                {
                    increaseAndDecreaseCount++;
                }

                System.out.print("Enter net income or Q to quit: ");
            }

            if (count > 0)
            {
                average = sum/count;
            }

            System.out.println(increaseAndDecreaseCount);
            System.out.println(largest);
            System.out.println(average);
        }
    }
}
