import java.util.ArrayList;
/**
 * Models a class with multiple static methods that can be called
 * @author Diljot Singh
 */
public class StaticPractice
{
    /**
     * Gets the largest value in the array
     * @param numbers the array to search the largest value for
     * @return largest the largest value if array is not empty, else return Integer.MIN_VALUE
     */
    public static double max(int[] numbers)
    {
        if (numbers.length == 0)
        {
            return Integer.MIN_VALUE;

        }
        else
        {
            int largest = numbers[0];
            for (Integer number : numbers)
            {
                if (number > largest)
                {
                    largest = number;
                }
            }
            return largest;
        }
    }

    /**
     * Gets the largest value in the ArrayList
     * @param numbers the ArrayList to search the largest value for
     * @return largest the largest value if the ArrayList is not empty, else return Integer.MIN_Value
     */
    public static double max(ArrayList<Integer> numbers)
    {
        if (numbers.size() == 0)
        {
            return Integer.MIN_VALUE;

        }
        else
        {
            int largest = numbers.get(0);
            for (Integer number : numbers)
            {
                if (number > largest)
                {
                    largest = number;
                }
            }
            return largest;
        }
    }

    /**
     * Determines if the target is in the array more than once
     * @param list the array to search
     * @param target the target to search for
     * @return found the boolean variable either true or false
     */
    public static boolean containsMultiple(String[] list, String target)
    {
        if (list.length == 0)
        {
            return false;
        }
        else 
        {
            boolean found = false;
            int count = 0;
            if (!found)
            {
                for (String goalValue : list)
                {
                    if (goalValue.equals(target))
                    {
                        count++;
                        if (count >=2)
                        {
                            found = true;
                        }
                    }
                }
            }
            return found;
        }
    }

    /**
     * Determines if the target is in the ArrayList more than once
     * @param list the ArrayList to search
     * @param target the target to search for
     * @return found the boolean variable either true or false
     */
    public static boolean containsMultiple(ArrayList<String> list, String target)
    {
        if (list.size() == 0)
        {
            return false;
        }
        else 
        {
            boolean found = false;
            int count = 0;
            if (!found)
            {
                for (String goalValue : list)
                {
                    if (goalValue.equals(target))
                    {
                        count++;
                        if (count >=2)
                        {
                            found = true;
                        }
                    }
                }
            }
            return found;
        }
    }
}
