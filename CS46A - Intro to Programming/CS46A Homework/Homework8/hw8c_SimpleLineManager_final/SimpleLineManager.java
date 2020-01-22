import java.util.ArrayList;
/**
 * Models a SimpleLineManager which manages a line in a 2-D space using an ArrayList
 * @author (Diljot Singh)
 * @version (10/18/2018)
 */
public class SimpleLineManager
{
    private ArrayList<SimpleLine> lines;
    /**
     * Constructs a lines ArrayList
     */
    public SimpleLineManager()
    {
        lines = new ArrayList<SimpleLine>();
    }

    /**
     * Adds this SimpleLine to the SimpleLineManager (to the ArrayList instance variable)
     * @param line the line to add to the ArrayList "lines"
     */
    public void add(SimpleLine line)
    {
        lines.add(line);
    }

    /**
     * Swaps the element at index1 with the element at index2
     * @param index1 the first index to swap with
     * @param index2 the second index to swap with
     */
    public void swap(int index1, int index2)
    {
        if (index1 < lines.size() && index2 < lines.size())
        {
            if(index1 >= 0 && index2 >= 0)
            {
                SimpleLine firstIndex = lines.get(index1);
                lines.set(index1, lines.get(index2));
                lines.set(index2, firstIndex);
            }
        }
    }

    /**
     * Gets the length for the shortest line
     * @return shortestLength the length of the shortest line
     */
    public double shortest()
    {
        if (lines.size() == 0)
        {
            return 0;
        }
        else
        {
            SimpleLine firstLine = lines.get(0);
            double shortestLength = getLength(firstLine);
            for (SimpleLine line : lines)
            {
                if (getLength(line) < shortestLength)
                {
                    shortestLength = getLength(line);

                }
            }
            return shortestLength;
        }
    }

    /**
     * Helper method for the shortest() method, calculates the length of a line using pythagorean theorem
     * @param line the line to calculate the length of
     * @return length the calculated length of a line
     */
    private double getLength(SimpleLine line)
    {
        double distanceX = line.getX2() - line.getX1();
        double distanceY = line.getY2() - line.getY1();
        //pythagorean theorem, finds the hypotenuse (length) of the line
        double length = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        return length;

    }

    @Override
    public String toString()
    {
        return lines.toString();
    }
}