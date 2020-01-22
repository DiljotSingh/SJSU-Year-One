import java.util.Scanner;
/**
 * Working with Scanner to get keyboard input
 * @author Diljot Singh
 */
public class InputApplication
{
    /**
     * manipulates various inputs and prints them
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integerInput1 = scan.nextInt();
        System.out.println(integerInput1);    
        
        System.out.print("Enter another integer: ");
        int integerInput2 = scan.nextInt();
        System.out.println(integerInput2);
        
        System.out.print("Enter a double: ");
        double doubleInput1 = scan.nextDouble();
        System.out.println(doubleInput1);
        
        int productOfIntegerInputs = (integerInput1 * integerInput2);
        System.out.println(productOfIntegerInputs);
        
        double integersAndDoubleQuotient = (productOfIntegerInputs/doubleInput1);
        System.out.println(integersAndDoubleQuotient);
        
        System.out.println((int)integersAndDoubleQuotient);
        
        
    }
    
}