
/**
 * Models a Circle that implements the GeometricShape interface
 */
public class Circle implements GeometricShape
{
    private int radius;
    /**
     * Constructor for objects of class Circle
     * @param r the radius of this circle
     */
    public Circle(int r)
    {
        // initialise instance variables
        radius = r;
    }

    /**
     * Gets the radius of this Circle
     * @return the radius of this circle
     */
    public int getRadius()
    {
        return radius;
    }
    
    /**
     * Sets a new radius for this Circle
     * @param r the radius of this circle
     */
     public void setRadius(int r)
    {
        radius = r;
    }
   
     /**
     * Gets the area of the Circle
     * @return the area of the Circle
     */
    public double area()
    {
        return Math.PI * Math.pow(radius,2);
    }
}