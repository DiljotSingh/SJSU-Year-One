/**
 * Tests the Snowman class.
 *
 * @author Kathleen O'Brien
 */
public class SnowmanViewer
{
    public static void main(String[] args)
    {
        Snowman snowman1 = new Snowman(50, 10);
        snowman1.draw();
        Snowman snowman2 = new Snowman(100, 30);
        snowman2.draw();
        Snowman snowman3 = new Snowman(150, 50);
        snowman3.draw();
    }
}