
/**
 * A subclass of the Rectangle class that uses CMYK colors only (Cyan, Magenta, Yellow, Black)
 *
 * @author Diljot Singh
 * @version (11-28-2018)
 */
public class CMYKRectangle extends Rectangle
{
    private String cmykColor = "";
    /**
     * Constructs a CMYK Rectangle with a default color of Cyan
     * @param x the x coordinate of the CMYK Rectangle
     * @param y the y coordinate of the CMYK Rectangle
     * @param w the width of the CMYK Rectangle
     * @param h the height of the CMYK Rectangle
     */
    public CMYKRectangle(int x, int y, int w, int h)
    {
        super(x, y, w, h);
        cmykColor = "cyan";
        super.setColor(Color.CYAN);
    }

    /**
     * Constructs a CMYK Rectangle with the given CMYK color
     * @param x the x coordinate of the CMYK Rectangle
     * @param y the y coordinate of the CMYK Rectangle
     * @param w the width of the CMYK Rectangle
     * @param h the heigh of the CMYK Rectangle
     * @param color the color to construct the CMYK Rectangle 
     */
    public CMYKRectangle(int x, int y, int w, int h, String color)
    {
        super(x,y,w,h);
        setCmykColor(color);
    }

    /**
     * Gets the color of this Rectangle
     * @return cmykColor the color of this Rectangle
     */
    public String getCmykColor()
    {
        return cmykColor;
    }

    /**
     * Sets the color of this Rectangle
     * @param newColor the new CMYK color to set the Rectangle to
     */
    public void setCmykColor(String newColor)
    {
        //the allowed colors (CMYK)
        String allowedColors = "CyanMagentaYellowBlack";
        //if the given color is one of the CMYK colors then it sets it to that given color
        //else it just sets the Rectangle the color "Cyan"
        if (allowedColors.toLowerCase().contains(newColor.toLowerCase()))
        {
            cmykColor = newColor;
            if (cmykColor.equalsIgnoreCase("Cyan"))
            {
                super.setColor(Color.CYAN);
            }
            else if (cmykColor.equalsIgnoreCase("Magenta"))
            {
                super.setColor(Color.MAGENTA);
            }
            else if (cmykColor.equalsIgnoreCase("Yellow"))
            {
                super.setColor(Color.YELLOW);
            }
            else
            {
                super.setColor(Color.BLACK);
            }
        }
        else
        {
            cmykColor = "cyan";
            super.setColor(Color.CYAN);
        }
    }

    /**
     * Overrides the setColor method in the Rectangle superclass to only allow CMYK colors
     * @param aColor any color, this method will not do anything
     */
    public void setColor(Color aColor)
    {
        //null
    }
}
