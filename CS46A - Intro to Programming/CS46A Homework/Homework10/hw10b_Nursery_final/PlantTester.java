/**
 * Tester for the Plant class
 */
public class PlantTester
{
    public static void main(String[] args)
    {
        Plant plant = new Plant("dwarf maple tree", 121.75);
        System.out.println(plant.getName() + " " + plant.getPrice());
        System.out.println("Expected: dwarf maple tree 121.75");
        
        plant = new Plant("blue star creeper flat", 15.95);
        System.out.println(plant.getName() + " " + plant.getPrice());
        System.out.println("Expected: blue star creeper flat 15.95");
        
        plant.setName("marigold jumbo pack");
        plant.setPrice( 6.25);
        System.out.println(plant.getName() + " " + plant.getPrice());
        System.out.println("Expected: marigold jumbo pack 6.25");
        
        
        
    }
}