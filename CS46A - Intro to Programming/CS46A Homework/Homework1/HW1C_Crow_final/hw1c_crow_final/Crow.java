/*
 * Display a picture of a crow
 * @author Kathleen O'Brien
 */
public class Crow
{
    public static void main(String[] args)
    {
        Picture crow = new Picture("crow.png");
        crow.translate(150,100);
        crow.grow(50, 42);
        crow.draw();

    }
}