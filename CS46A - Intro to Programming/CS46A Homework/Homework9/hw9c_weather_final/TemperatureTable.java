/**
 * Models a 2D Array that holds monthly temperatures for various cities
 * @author Diljot Singh
 */
public class TemperatureTable
{
    int[][] temperatures;
    String cityName = "";
    /**
     * Constructs a TemperatureTable for a city
     * @param city the city to construct this table for
     * @param temperatures the array representing the monthly temperatures
     */
    public TemperatureTable(String city, int[][] temperatures)
    {
        this.temperatures = temperatures;
        cityName = city;
    }

    /**
     * Gets the element in the last column of the last row
     * @return lastElement the last element 
     */
    public int last()
    {
        int [] lastRow = temperatures[temperatures.length-1];
        int lastElement = lastRow[lastRow.length - 1];
        return lastElement;
    }

    /** 
     * Gets the name of the city 
     * @return cityName the name of the city
     */
    public String getName()
    {
        return cityName;
    }

    /**
     * Gets the largest value in the 2D array
     * @return largest the largest value
     */
    public int getHighest()
    {
        int[] firstRow = temperatures[0];
        int largest = firstRow[0];
        for (int[] temperature : temperatures)
        {
            for (int temperatureValue : temperature)
            {
                if (temperatureValue > largest)
                {
                    largest = temperatureValue;
                }
            }
        }
        return largest;
    }

    /**
     * Checks if the targest is in the array
     * @param target the value to search the array for
     * @return found the boolean variable to return 
     */
    public boolean contains(int target)
    {
        boolean found = false;
        if (!found)
        {
            for (int[] temperature : temperatures)
            {
                for (int temperatureValue : temperature)
                {
                    if (temperatureValue == target)
                    {
                        found = true;
                    }
                } 
            }
        }
        return found;
    }

}