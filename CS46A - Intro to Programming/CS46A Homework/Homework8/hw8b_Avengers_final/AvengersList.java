import java.util.ArrayList;
/**
 * Models an ArrayList that stores names of Avengers as strings
 * @author (Diljot Singh)
 * @version (10/18/2018)
 */
public class AvengersList
{
    public static void main(String[] args)
    {
        ArrayList<String> avengers = new ArrayList<String>();
        avengers.add("Captian America");
        avengers.add("Hulk");
        avengers.add("Iron Man");
        avengers.add("Thor");
        avengers.add(1, "Black Panther");
        avengers.set(2,"Black Widow");
        avengers.set(avengers.size() - 2, "Hawkeye");
        avengers.remove("Thor");
        System.out.println(avengers.get(0) + "***");
        System.out.println(avengers.toString());
        for (String avenger : avengers)
        {
            System.out.println(avenger);
        }

    }
}
