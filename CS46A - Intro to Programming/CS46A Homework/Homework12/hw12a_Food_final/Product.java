/**
 * Models a product wih a price and description
 */
public class Product
{
    private double price;
    private String description;
    
    /**
     * Constructs a Product with a price and description
     * @param thePrice the price of this product
     * @param theDescription the description of this
     * product
     */
    public Product(String theDescription, double thePrice )
    {
         price = thePrice;
         description = theDescription;
    }
    
    /**
     * Gets the price of this Product
     * @return the price of this object
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Gets the description of this Product
     * @return the description of this Product
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Reduce the price by the given percent
     * @param percent the pecentage to reduce the price by
     */
    public void reducePrice(double percent)
    {
        
        price = price - price * percent/100;
    }
    
    /**
     * Increase the price of the Product by the 
     * given percent
     * @param percent the percentage to increase the 
     * price by
     */
    public void increasePrice(double percent)
    {
        price = price * (1.0 + percent/100);
    }
    
}