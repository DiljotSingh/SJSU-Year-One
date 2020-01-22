
/**
 * Models a Snowglobe with moving particles
 * @author Diljot Singh
 */
public class SnowGlobe
{
    private double radius;
    //constants below
    public static final double DEFAULT_RADIUS = 10;
    public static final double MAX_RADIUS = 50;
    public static final double WHITE_PARTICLES = .20;
    public static final double LIQUID = .50;
    public static final double SCENERY = .30;
    public static final double SNOW_COST_PER_CUBIC_CENTIMETER = 1.25;
    /**
     * Constructs a SnowGlobe object with the given radius
     * @param theRadius the radius of this snowglobe 
     */
    public SnowGlobe(double theRadius)
    {
        //radius is in centimeters
        setRadius(theRadius);
    }

    /**
     * Constructs a new Snowglobe object with DEFAULT_RADIUS
     */
    public SnowGlobe()
    {
        //radius is in centimeters
        setRadius(DEFAULT_RADIUS);
    }

    /**
     * Sets the radius to a new radius
     * @param newRadius the new radius for this Snowglobe
     */
    public void setRadius(double newRadius)
    {
        if (newRadius <= 0)
        {
            this.radius = DEFAULT_RADIUS;

        }
        else if ((newRadius > MAX_RADIUS))
        {
            this.radius = MAX_RADIUS;

        }
        else
        {
            this.radius = newRadius;
        }
    }

    /**
     * Gets the radius of this Snowglobe
     * @return radius the radius of this Snowglone
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Gets the volume of this SnowGlobe
     * @return totalVolume the volume of this SnowGlobe
     */
    public double getVolume()
    {
        //volume is in cubic centimeters
        double totalVolume = (4.0/3) * Math.PI * Math.pow(radius,3);
        return totalVolume;
    }

    /**
     * Gets the volume of the snow 
     * @return snowVolume the volume of the snow in this SnowGlobe
     */
    public double getSnowVolume()
    {
        //volume is in cubic centimeters
        double snowVolume = getVolume() * WHITE_PARTICLES;
        return snowVolume;

    }

    /**
     * Gets the cost of the snow
     * @return snowCost the cost of the snow
     */
    public double getSnowCost()
    {
        //snowCost is in U.S dollars
        double snowCost = getSnowVolume() * SNOW_COST_PER_CUBIC_CENTIMETER;
        return snowCost;
    }
}
