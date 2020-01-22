/**
 * Models a computer with a brand and a clock speed in gigahertz 
 */
public class Computer implements Comparable
{
    String brand = "";
    double ghz = 0;
    /**
     * Constructs a Computer with a brand and gigahertz
     * @param brand the brand of the Computer
     * @param ghz gigahertz, the clock speed of the computer
     */
    public Computer(String brand, double ghz)
    { 
        this.brand = brand;
        this.ghz = ghz;
    }

    /**
     * Gets a string representation of the object
     * @return a string representation of the object
     */
    public String toString()
    {
        String s = getClass().getName()
            + "[brand=" + brand
            + ",gigahertz=" + ghz 
            + "]";
        return s;
    }

    /**
     * Gets the ghz of this Computer
     * @return ghz the gigahertz
     */
    public double getGhz()
    {
        return ghz;
    }

    /**
     * Gets the brand of this Computer
     * @return brand the brand
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Compares this Object to otherObject
     * @param otherObject
     * @return -1, 1, or 0
     */
    public int compareTo(Object otherObject)
    {
        Computer otherComputer = (Computer) otherObject;
        int value = Double.compare(ghz, otherComputer.getGhz());
        if (value == 0)
        {
            value = brand.compareTo(otherComputer.getBrand());
        }
        return value;
    }
}