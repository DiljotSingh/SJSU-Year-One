import java.util.Scanner;
/**
 * Takes a String input and manipulates it using the Scanner object
 * @author Diljot Singh
 */
public class StringStuff
{
    /**
     * Creates a scanner and then prints string type outputs by manipulating given input
     */
    public static void main(String[] args)
    {
        Scanner stringScanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String input = stringScanner.nextLine();
  
        System.out.println(input.substring(0,1));
        System.out.println(input.substring(input.length()-1));
        System.out.println(input.substring(0, input.indexOf(" ")));
        System.out.println(input.substring(input.indexOf(" ") + 1));
        System.out.println(input.substring(2,4));
        
    }
}
