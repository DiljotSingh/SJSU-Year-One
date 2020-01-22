/**
 * A tester for the SnowGlobe class
 * @author Kathleen O'Brien
 */
public class SnowGlobeTester
{
    public static void main(String[] args)
    {
        SnowGlobe globe = new SnowGlobe();
        System.out.println(globe.getRadius());
        System.out.println("Expected: 10.0");
        
        globe.setRadius(1.0);
        System.out.println(globe.getRadius());
        System.out.println("Expected: 1.0");
        
        globe.setRadius(5.0);
        System.out.println(globe.getRadius());
        System.out.println("Expected: 5.0");
        
        
        
    }
}