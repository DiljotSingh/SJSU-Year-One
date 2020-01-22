import java.util.Arrays;
/**
 * Manages a collection of SimpleLine objects
 *
 * @author Diljot Singh
 */

public class SimpleLineArrayManager
{
    private SimpleLine[] lines;
    /**
     * Constructs a SimpleLineArrayManager object
     * @param lines the ArrayList to set this.lines equal to
     */
    public SimpleLineArrayManager(SimpleLine[] lines)
    {
        this.lines = lines;
    }

    /**
     * Gets the sum of the length of all the lines in the array
     * @return sum the sum of all the lengths of the lines in the array
     */
    public double sum()
    {
        double sum = 0;
        for (SimpleLine line : lines)
        {
            sum = sum + getLength(line);
        }
        return sum;
    }

    /**
     * Computes the length of a line using pythagorean theorem
     * @param line the line to calculate the length for
     * @return length the length of the line
     */
    private double getLength(SimpleLine line)
    {
        double distanceX = line.getX2() - line.getX1();
        double distanceY = line.getY2() - line.getY1();
        // pythagorean theorem
        double length = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY,2));
        return length;
    }

    /** 
     * Swaps two elements in the array
     * @param index1 the first element in the swap
     * @param index2 the second element in the swap
     */
    public void swap (int index1, int index2)
    {
        if ((index1 >= 0 && index1 < lines.length) && (index2 >= 0 && index2 <lines.length))
        {
            SimpleLine temp = lines[index1];
            lines[index1] = lines[index2];
            lines[index2] = temp;
        }
    }
    
    /** 
     * Gets the shortest line
     * @return shortestLine the shortest line
     */
    public SimpleLine shortest()
    {
        if (lines.length == 0)
        {
            return null;
        }
        else
        {
            SimpleLine shortestLine = lines[0];
            for (SimpleLine line : lines)
            {
                if (getLength(line) < getLength(shortestLine))
                {
                    shortestLine = line;
                }
            }
            return shortestLine;
        }
    }

    @Override
    public String toString()
    {
        return Arrays.toString(lines);
    }
}