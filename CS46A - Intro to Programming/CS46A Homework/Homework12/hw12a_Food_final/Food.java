
/**
 * A subclass of Product which models a Food Product
 *
 * @author Diljot Singh
 * @version (11-28-2018)
 */
public class Food extends Product
{
    private int totalCalories = 0;
    private int totalCaloriesFromFat = 0;
    /**
     * Constructs a Food Product that has a description, price, total calories, and calories from fat
     * @param String description the description of this Food Product
     * @param double price the price of this Food Product
     * @param int calories the total number of calories in this Food Product
     * @param int caloriesFromFat the number of calories from fat in this Food Product
     */
    public Food (String description, double price, int calories, int caloriesFromFat)
    {
        super(description,price);
        totalCalories = calories;
        totalCaloriesFromFat = caloriesFromFat;

    }

    /**
     * Gets the total number of calories in this Food Product
     * @return totalCalories the total number of calories 
     */
    public int getCalories()
    {
        return totalCalories;
    }

    /**
     * Gets the total number of calories from fat in this Food Product
     * @return totalCaloriesFromFat the total number of calories from fat
     */
    public int getCaloriesFromFat()
    {
        return totalCaloriesFromFat;
    }

    /**
     * Tells if this Food is allowed in the diet (true if totalCaloriesFromFat is less than 1/3 of totalCalories)
     * @return boolean true or false
     */
    public boolean isAllowed()
    {
        if (totalCaloriesFromFat < (totalCalories/3.0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gets the description of this Food
     * @return description the description of this Food 
     */
    public String getDescription()
    {
        String percentageFatCalories = String.format("%.1f", totalCaloriesFromFat * 100.0 / totalCalories);
        return (super.getDescription() + " %fat" + "=" + percentageFatCalories);

    }
}
