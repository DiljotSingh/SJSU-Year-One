
/**
 * Models a Plant that has a name and price
 * @author Diljot Singh
 * @version (11/1/2018)
 */
public class Plant
{
    String name = "";
    double price = 0;
    /**
     * Constructs a Plant that has a name and price
     * @param name the name of the plant
     * @param price the price of the plant
     */
    public Plant(String name, double price)
    {
        setName(name);
        setPrice(price);
    }

    /**
     * Gets the name of this Plant
     * @return name the name of the Plant
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this Plant
     * @param newName the name to set for the Plant
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Gets the price of this Plant
     * @return price the price of this Plant
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Sets the price of this Plant
     * @param newPrice the price to set for the Plant
     */
    public void setPrice(double newPrice)
    {
        if (newPrice < 0)
        {
            price = 0;
        }
        else
        {
            price = newPrice;
        }
    }
}
