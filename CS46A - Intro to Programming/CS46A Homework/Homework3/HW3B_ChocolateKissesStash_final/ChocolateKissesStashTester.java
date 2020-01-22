/**
 * Tests the class ChocolateKissesStash.
 *
 * @author Kathleen O'Brien
 */
public class ChocolateKissesStashTester
{
    public static void main(String[] args)
    {
        ChocolateKissesStash stash = new ChocolateKissesStash(50);
        System.out.println("Capacity: " + stash.getMaxCapacity());
        System.out.println("Expected: 50");
        
        System.out.println("Amount: " + stash.getCurrentAmount());
        System.out.println("Expected: 0");
        
        stash.eat(10);
        stash.buyMore(20);
        System.out.println("Amount: " + stash.getCurrentAmount());
        System.out.println("Expected: 0");
        
        stash = new ChocolateKissesStash(100);
        System.out.println("Capacity: " + stash.getMaxCapacity());
        System.out.println("Expected: 100");      
    }
}