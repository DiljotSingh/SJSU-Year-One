
/**
 * Models a Snowman at specific coordinates x and y
 * @author Diljot Singh
 */
public class Snowman
{
    private int x;
    private int y;
    /**
     * Constructs a Snowman object with specified coordinates x and y
     * @param theX the x coordinate
     * @param theY the y coordinate
     */
    public Snowman(int theX, int theY)
    {
        this.x = theX;
        this.y = theY;
    }
    
    /**
     * Draws the Snowman's different shapes at given x and y coordinates
     */
    public void draw()
    {
        //snowman hat
        Rectangle snowmanHat = new Rectangle(x,y,20,20);
        snowmanHat.fill();
        
        //snowman hat brim
        Line brim = new Line(x-10,y+20,x+30,y+20);
        brim.draw();
        
        //snowman top circle
        Ellipse topCircle = new Ellipse(x, y+20, 20, 20);
        topCircle.draw();
        
        //snowman middle circle
        Ellipse middleCircle = new Ellipse(x-10, y+40, 40, 40);
        middleCircle.draw();
        
        //snowman bottom circle
        Ellipse bottomCircle = new Ellipse(x-20, y+80, 60, 60);
        bottomCircle.draw();
             
    }
}
