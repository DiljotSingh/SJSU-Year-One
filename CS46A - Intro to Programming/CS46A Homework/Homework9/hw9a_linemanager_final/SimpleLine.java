/**
 * Represents a line in 2-d space
 */
public class SimpleLine 
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Constructs a line with a given starting and ending location.
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public SimpleLine(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * Gets the X coordinate of the start point
     * @return the X coordinate of the start point
     */
    public int getX1()
    {
        return x1;
    }

    /**
     * Gets the Y coordinate of the start point
     * @return the Y coordinate of the start point
     */
    public int getY1()
    {
        return y1;
    }
    
        /**
     * Gets the X coordinate of the end point
     * @return the X coordinate of the end point
     */
    public int getX2()
    {
        return x2;
    }
    
    /**
     * Gets the Y coordinate of the end point
     * @return the Y coordinate of the end point
     */
    public int getY2()
    {
        return y2;
    }
    
    @Override
    /**
     * 
     */
    public String toString()
    {
        String s = "SimpleLine[x1=" + x1
           + ",y1=" + y1
           + ",x2=" + x2
           + ",y2=" + y2 +"]";
        return s;
    }
}