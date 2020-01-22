/**
 * Tests the CMYKRectangle class.
 */
public class CMYKRectangleViewer
{
    public static void main(String[] args)
    {
        //with default color
        CMYKRectangle r = new CMYKRectangle(10, 20, 20, 40);
        r.fill();             
        Text message = new Text(10, 70, r.getCmykColor());
        message.draw();
                            
        // cyan
        r = new CMYKRectangle(60, 20, 20, 40, "cyan");
        r.fill();
        message = new Text(60, 70, r.getCmykColor());
        message.draw();
        
        //set a bad color 
        r = new CMYKRectangle(110, 20, 20, 40, "cyan");
        r.setCmykColor("purple"); //should have no effect
        r.fill();
        message = new Text(110, 70, r.getCmykColor());
        message.draw();
        
        //construct with bad color
        r = new CMYKRectangle(160, 20, 20, 40, "orange");
        r.fill();
        message = new Text(160, 70, r.getCmykColor());
        message.draw();
        
        //magenta
        r = new CMYKRectangle(210, 20, 20, 40, "magenta");
        r.fill();
        message = new Text(210, 70, r.getCmykColor());
        message.draw();
        
        //yellow
        r = new CMYKRectangle(265, 20, 20, 40, "yellow");
        r.fill();
        message = new Text(265, 70, r.getCmykColor());
        message.draw();
        
        //black
        r = new CMYKRectangle(315, 20, 20, 40, "black");
        r.setColor(Color.GREEN); //should be black not green
        r.fill();
        message = new Text(315, 70, r.getCmykColor());
        message.draw();

    }
  
}