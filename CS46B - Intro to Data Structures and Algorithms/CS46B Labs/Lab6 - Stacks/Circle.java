package stacklab;

import java.awt.*;


class Circle 
{
	private Point		center;
	private int			radius;
	private Color		fill;
	
	
	Circle(Point center, int radius, Color fill)
	{
		this.center = center;
		this.radius = radius;
		this.fill = fill;
	}
	
	
	public String toString()
	{
		return "Circle at " + center + ", radius = " + radius + ", fill color = " + fill;
	}
	
	
	void paint(Graphics g)
	{
		g.setColor(fill);
		g.fillOval(center.x-radius, center.y-radius, 2*radius, 2*radius);
	}
}
