/**
 * Manipulate Day objects
 * @author Kathleen O'Brien
 */
public class DaysUntilPrinter
{
    public static void main(String[] args)
    {
        //put your code here
        
        Day today = new Day();
        System.out.println("Today is " + today.toString());
        
       
        Day Thanksgiving = new Day(2018, 11, 22);
        int days = Thanksgiving.daysFrom(today);
        System.out.println(days);
        
        today.addDays(30);
        int year = today.getYear();
        int month = today.getMonth();
        int dayofMonth = today.getDayOfMonth();
        
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayofMonth);
        
        
        
        
        
       
        
        //do not change this line
        
        
    }
}