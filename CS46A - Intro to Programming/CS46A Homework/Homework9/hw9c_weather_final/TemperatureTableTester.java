
/**
 * Write a description of class MonthlyTemperatureTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TemperatureTableTester
{
    public static void main(String[] args)
    {
        int[][] sjTemps = {{57, 58, 40},
           {62, 60, 45},
           {66, 65, 65},
           {70, 72, 68},
           {75, 73, 72},
           {80, 81, 83},
           {83, 84, 90},
           {82, 82, 87},
           {81, 80, 81},
           {74, 75, 71},
           {65, 66, 68},
           {58, 58, 59}
        };
        
        TemperatureTable sj = new TemperatureTable("San Jose", sjTemps);
        System.out.println(sj.getName() + " high:" + sj.getHighest());
        System.out.println("Expected: 90");
        System.out.println(sj.contains(100));
        System.out.println("Expected: false");
        System.out.println(sj.contains(58));
        System.out.println("Expected: true");
        
        int[][] spTemps = {{-17, -15},
           {-58, -63},
           {-65, -80}
        };
        
        TemperatureTable southPole = new TemperatureTable("South Pole", spTemps);
        System.out.println(southPole.getName() + " high:" + southPole.getHighest());
        System.out.println("Expected: -15");
        System.out.println(southPole.contains(0));
        System.out.println("Expected: false");
        
        
    }
}