import java.util.Arrays;
/**
 * Tests the  Computer class.
 * 
 */
public class ComputerRunner
{
    public static void main(String[] args)
    {
        Computer[] inventory = new Computer[6];
        inventory[1] = new Computer("Apple Mac Air", 3.4);
        inventory[0] = new Computer("Surface Pro 4", 3.4);
        inventory[2] = new Computer("Apple Mac Air", 2.5);
        inventory[4] = new Computer("Dell Inspiron", 3.8);
        inventory[5] = new Computer("Sony Vivio", 2.5);
        inventory[3] = new Computer("Acer Aspire", 2.5);
        
        System.out.println(inventory[1].getBrand() + " "
               + inventory[1].getGhz());

        Arrays.sort(inventory);
        
        for (Computer c : inventory)
        {
            System.out.println(c);
        }
    }
}