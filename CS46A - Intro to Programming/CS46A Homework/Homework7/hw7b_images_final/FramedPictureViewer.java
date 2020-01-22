/**
 * An application to frame an image in a circle
 */
public class FramedPictureViewer
{
    public static void main(String[] args)
    {
        Picture cat = new Picture("oliver.jpg");
        cat.translate(10,10);
        FramedPicture framedcat = new FramedPicture(cat);
        framedcat.frame();
        cat.draw();
        
        Picture taran = new Picture("taran.jpg");
        taran.translate(230, 210);
        FramedPicture framedTaran = new FramedPicture(taran);
        framedTaran.frame();
        taran.draw();        
    }
}