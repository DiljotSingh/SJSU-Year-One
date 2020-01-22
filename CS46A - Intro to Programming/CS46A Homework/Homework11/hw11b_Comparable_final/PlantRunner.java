import java.util.Collections;
import java.util.ArrayList;
/**
 * 
 */
public class PlantRunner
{
    public static void main(String[] args)
    {
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Plant("dwarf maple tree", 121.75));
        plants.add(new Plant("blue star creeper flat", 15.95));
        plants.add(new Plant("marigold jumbo pack", 6.20));
        plants.add(new Plant("tomato plant", 4.50));
        plants.add(new Plant("lemon cucumber", 4.50));
        plants.add(new Plant("California poppy 6-pack", 6.00));

        Collections.sort(plants);
        
        //They will still be in original order - not sorted
        //since campareTo is a stub
        for(Plant b : plants)
        {
            System.out.println(b.getName() + " " + b.getPrice());
        }
    }
}