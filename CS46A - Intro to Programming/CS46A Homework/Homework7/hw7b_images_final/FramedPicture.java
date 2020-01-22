
/**
 * Models a framed picture that iterates through pixels
 * @author Diljot Singh
 */
public class FramedPicture
{
    private Picture picture;
    /**
     * Constructs a FramedPicture object that takes a Picture as a parameter
     * @param thePicture the picture to manipulate, inspect, and modify
     */
    public FramedPicture(Picture thePicture)
    {
        picture = thePicture;

    }

    /**
     * Returns the picture in a round frame
     * @return picture the picture after setting the frame
     */
    public Picture frame()
    {
        double height = picture.getHeight();
        double width = picture.getWidth();
        double radius = 0;
        if (height > width)
        {
            radius = width * 0.40;
        }
        else
        {
            radius = height * 0.40;
        }
        double xCenter = width/2;
        double yCenter = height/2;
        /* calculates the distance of each pixel from the center using the distance formula
        and if it is greater than the radius, color it black */
        for (int x = 0; x < width; x++) 
        { 
            for (int y = 0; y < height; y++)
            {
                if ((Math.sqrt((Math.pow(x-xCenter,2) + Math.pow(y-yCenter,2))))> radius)
                {
                    picture.setColorAt(x, y, Color.BLACK);
                }
            }
        }

        return picture;
    }
}
