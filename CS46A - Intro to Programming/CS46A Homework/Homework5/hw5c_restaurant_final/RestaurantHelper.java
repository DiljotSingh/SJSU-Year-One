/**
 * Models a RestaurantHelper to help customers with the bill
 * @author Diljot Singh
 */
public class RestaurantHelper
{
    private double costOfMeal;
    private int qualityOfService;
    
    public static final int EXCELLENT_SERVICE = 3;
    public static final int GOOD_SERVICE = 2;
    public static final int FAIR_SERVICE = 1;
    public static final int POOR_SERVICE = 0;
    
    public static final double EXCELLENT_TIP = .25;
    public static final double GOOD_TIP = .20;
    public static final double FAIR_TIP = .10;
    public static final double POOR_TIP = .05;
    public static final double TAX_RATE = 0.09;
   
    /**
     * Constructs a new RestaurantHelper with given meal cost 
     * and service quality
     * @param mealCost the cost of the meal
     * @param serviceQuality the quality of the service
     */
    public RestaurantHelper(double mealCost, int serviceQuality)
    {
        costOfMeal = mealCost;
        if (mealCost < 0)
        { 
            costOfMeal = 0;
        }
        // else costOfMeal = mealcost;
        qualityOfService = serviceQuality;
        if (serviceQuality > EXCELLENT_SERVICE)
        {
            qualityOfService = EXCELLENT_SERVICE;
        }
        
        if (serviceQuality < 0)
        {
            qualityOfService = POOR_SERVICE;
        }
    }
    
    /**
     * Gets the amount to tip according to quality of service
     * @return tip
     */
    public double tip()
    {
        double tip = 0;
        if (qualityOfService == EXCELLENT_SERVICE)
        {
            tip = EXCELLENT_TIP * costOfMeal;
        }
        if (qualityOfService == GOOD_SERVICE)
        {
            tip = GOOD_TIP * costOfMeal;
        }
        if (qualityOfService == FAIR_SERVICE)
        {
            tip = FAIR_TIP * costOfMeal;
        }
        if (qualityOfService == POOR_SERVICE)
        {
            tip = POOR_TIP * costOfMeal;
        }
        return tip;
    }
    
    /**
     * Gets the amount of tax on the costOfMeal
     * @return tax (tax rate times meal cost)
     */
    public double tax()
    {
        double tax = 0;
        tax = TAX_RATE * costOfMeal;
        return tax;
        
    }
    
    /**
     * Gets the total cost of the meal including tip and tax
     * @return costOfMeal the cost of the meal
     */
    public double totalCost()
    {
        this.costOfMeal = costOfMeal + tax() + tip();
        return costOfMeal;
    }
    
    /**
     *  Gets the quality of service
     *  @return the quality of the service
     */
    public int qualityOfService()
    {
        return qualityOfService;
    }
    
    /**
     * Gets the base cost of the meal (no tip or tax) 
     * @return the cost of the meal before tax and tip
     */
    public double costOfMeal()
    {
        return costOfMeal;
    }
       
}