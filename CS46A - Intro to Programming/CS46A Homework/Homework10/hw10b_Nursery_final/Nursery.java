import java.util.ArrayList;
/**
 * Models a Nursery which sells Plants
 * @author Diljot Singh
 * @version (11-1-2018)
 */
public class Nursery
{
    private ArrayList<Plant> nursery;
    /**
     * Constructs a Nursery which has an ArrayList to manage Plants
     */
    public Nursery()
    {
        nursery = new ArrayList<Plant>();
    }

    /**
     * Adds the specified Plant to the Nursery
     * @param plant the plant to add 
     */
    public void add(Plant plant)
    {
        nursery.add(plant);
    }

    /**
     * Finds the average cost of all Plants in the Nursery
     * @return average the average cost of all the plants
     */
    public double average()
    {
        if (nursery.size() == 0)
        {
            return 0;
        }
        else
        {
            double average = 0;
            double totalPrice = 0;
            int count = 0;
            for (Plant plant : nursery)
            {
                totalPrice = totalPrice + plant.getPrice();
                count++;
            }
            average = (totalPrice/count);
            return average;
        }
    }

    /**
     * Determines if this Nursery and otherNursery contain Plants with the same name
     * @param otherNursery the other nursery to check
     * @return match the boolean true or false 
     */
    public boolean sameContents(Nursery otherNursery)
    {
        if (nursery.size() != (otherNursery.nursery).size())
        {
            return false;
        }
        boolean match = true;
        for (Plant plantX : nursery)
        {
            boolean otherContains = false;
            for (Plant plantY : otherNursery.nursery)
            {
                if (plantY.getName().equals(plantX.getName()))
                {
                    otherContains = true;
                }
            }
            if (otherContains == false)
            {
                match = false;
            }
        }

        return match;
    }

    /**
     * Gets an ArrayList with names of Plants in the Nursery
     * @return list the ArrayList with the names of the Plants
     */
    public ArrayList plantList()

    {
        ArrayList<String> list = new ArrayList<String>();

        for (Plant plant : nursery)
        {
            list.add(plant.getName());

        }
        return list;
    }
}
