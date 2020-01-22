/**
 * Draws a snowman
 * @author
 */
public class SnowmanViewer
{
    public static void main(String[] args)
    {
        //Draws the hat of the snowman and fills it with black
        Rectangle snowmanHat = new Rectangle(50,10,20,20);
        snowmanHat.fill();
        //Draws the brim of the hat (line)
        Line brim = new Line(40, 30, 80, 30);
        brim.draw();
        
        Ellipse c1 = new Ellipse(50, 30, 20, 20);
        c1.draw();
        Ellipse c2 = new Ellipse(40, 50, 40, 40);
        c2.draw();
        Ellipse c3 = new Ellipse(30, 90, 60, 60);
        c3.draw();
    }
}