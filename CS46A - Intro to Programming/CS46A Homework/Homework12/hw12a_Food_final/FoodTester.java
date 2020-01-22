/**
 * Test Food class
 */
public class FoodTester
{
    public static void main(String[] args)
    {
        Food pizza = new Food("Pizza Hut pepperoni pizza", 18.50, 380, 180);
        Food bread = new Food("Orowheat whole wheat bread", 4.00, 90, 10);
        Food soup = new Food("Hearty soup", 2.50, 151, 51);
        Food snickers = new Food("Snickers", 2.00, 280, 122);

        //you can always assign a subclass object to a 
        //superclass reference
        Product p = pizza;

        //answers should be correct in final
        System.out.println("Allowed: " + pizza.isAllowed());
        System.out.println("Expected: false");
        System.out.println("Allowed: " + bread.isAllowed());
        System.out.println("Expected: true");
        System.out.println("Allowed: " + soup.isAllowed());
        System.out.println("Expected: false");
        System.out.println("Allowed: " + snickers.isAllowed());
        System.out.println("Expected: false");

        //has been overriden
        System.out.println(pizza.getDescription());
        System.out.println("Expected: Pizza Hut pepperoni pizza %fat=47.4");
        System.out.println(soup.getDescription());
        System.out.println("Expected: Hearty soup %fat=33.8");
        System.out.println(bread.getDescription());
        System.out.println("Expected: Orowheat whole wheat bread %fat=11.1");
        
    }
}