package func;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

import javax.swing.*;


// 
// A JPanel that uses an instance of DoubleFunctionOfTwoInts. Size is hardcoded. When the DoubleFunctionOfTwoInts
// is changed (via calls to setFunction()), the new function is applied to (width,height) space, with function values
// translated to colors. Pixel colors are stored in a buffered image.
//


public class VizPanel extends JPanel
{
	// Static constants are the only variables that should start with a capital letter. In fact,
	// they should be in all capitals. I line up the declarations, names, and equals-signs.
	private final static int			WIDTH_PIXELS		= 700;
	private final static int			HEIGHT_PIXELS		= 500;
	private final static int			MAX_XFERABLE		= 255;
	private final static int[]			RGBS;
	
	
	// This is a static initializer. It executes once, when the JVM loads the class, before any
	// instances are constructed. Static initializers aren't part of CS46A or B.
	static
	{
		RGBS = new int[MAX_XFERABLE+1]; 
		float hue = 0f;											// variable hue across the spectrum
		float deltaHue = 1f / (1+MAX_XFERABLE);
		for (int i=0; i<=MAX_XFERABLE; i++, hue+=deltaHue)
			RGBS[i] = Color.HSBtoRGB(hue, 1, 1);				// maximum saturation and brightness
	}
	
	
	// For instance variables, I line up the declarations and also the variable names.
	private DoubleFunctionOfTwoInts		function;
	private BufferedImage				image;
	
	
	public VizPanel(DoubleFunctionOfTwoInts function)
	{
		this.function = function;
		setPreferredSize(new Dimension(WIDTH_PIXELS, HEIGHT_PIXELS));
	}
	
	
	// A transfer function is any conversion from a number to a color.
	private static int transfer(double d)
	{
		int n = (int)Math.round(d);
		if (n == 0)
			return 0;				//  0 -> black
		n = n % RGBS.length;		// modulo brings n into range
		if (n == 0)
			n = 1;
		while (n < 0)
			n += RGBS.length;
		return RGBS[n];
	}
	
	
	// Apply user-selected implementation of function.
	private void recomputeImage()
	{
		// Build blank image.
		int w = getWidth();
		int h = getHeight();
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		// Function is null => show axes. 
		if (function == null)
		{
			Graphics2D g = (Graphics2D)image.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, w, h);
			g.setColor(Color.BLACK);
			int[] axisHalfLens = { (int)(0.95f * Math.max(w, h)/2), (int)(0.95f * Math.min(w, h)/2) };
			AffineTransform xform = g.getTransform();
			g.translate(w/2, h/2);
			for (int i=0; i<4; i++)
			{
				// In each of 4 cardinal directions, draw a ray with an arrowhead.
				g.drawLine(0, 0, axisHalfLens[i%2], 0);
				g.drawLine(axisHalfLens[i%2], 0, axisHalfLens[i%2]-10, 7);
				g.drawLine(axisHalfLens[i%2], 0, axisHalfLens[i%2]-10, -7);
				g.rotate(Math.PI/2);
			}
			g.setTransform(xform);
			g.translate(w/2, h/2);
			for (int x=-320; x<=320; x+=10)
			{
				if (x == 0)
					continue;
				// Ticks and values on X axis.
				int tickLen = (x%50 == 0)  ?  20  :  8;
				g.drawLine(x, -tickLen/2, x, tickLen/2);
				if (x%50 == 0)
				{
					String s = "" + x;
					int sw = g.getFontMetrics().stringWidth(s);
					g.drawString(s, x-sw/2, 22);
				}
				// Ticks and values on Y axis.
				if (x >= -220  &&  x <= 220)
				{
					g.drawLine(-tickLen/2, x, tickLen/2, x);
					if (x%50 == 0)
					{
						String s = "" + -x;
						g.drawString(s, tickLen/2 + 12, x+4);
					}
				}
			}
			g.setTransform(xform);
		}
		
		// Function is non-null. For each (x,y) point, compute f(x,y), convert to color,
		// and paint pixel at (x,y).
		else
		{
			for (int row=h-1; row>=0; row--)
			{
				int y = h/2 - row;
				//int y = row - h/2;
				for (int col=0; col<w; col++)
				{
					int x = col - w/2;
					double fn = function.fOfXY(x, y);
					int rgb = transfer(fn);
					image.setRGB(col, row, rgb);
				}
			}
		}
	}
	
	
	// To make a new image, set this.image to null and then repaint.
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (image == null)
			recomputeImage();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
	
	
	void setFunction(DoubleFunctionOfTwoInts function)
	{
		this.function = function;
		image = null;
		repaint();
	}
	
	
	// Not part of the app. This class is a color legend panel. A screenshot appears 
	// in the assignment instructions.
	private static class ColorLegend extends JPanel
	{
		public Dimension getPreferredSize()
		{
			return new Dimension(800, 400);
		}
		
		public void paintComponent(Graphics g)
		{
			// Clear.
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			
			// Cache default affine transform.
			AffineTransform dfltXform = g2.getTransform();
			
			// Axis.
			g2.setStroke(new BasicStroke(2));
			g2.translate(20, getHeight()-50);
			g2.setColor(Color.BLACK);
			g2.drawLine(0, 0, 3*256, 0);
			
			// Ticks and labels.
			AffineTransform xform = g2.getTransform();
			int x = 0;
			for (int i=0; i<256; i+=5)
			{
				x = i * 3;
				g2.setColor(Color.BLACK);
				g2.drawLine(x, -10, x, 10);
				g2.translate(x, 18);
				g2.rotate(Math.PI/2);
				g2.drawString(""+i, 0, 4);
				g2.setTransform(xform);
			}
			
			// Colors.
			g2.setStroke(new BasicStroke(1));
			x = 0;
			for (int i=0; i<256; i++)
			{
				x = i * 3;
				g2.setColor(new Color(transfer(i)));
				for (int j=0; j<3; j++)
					g2.drawLine(x+j, -20, x+j, -800);
			}
			
			g2.setTransform(dfltXform);
		}
	}
	
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.add(new ColorLegend());
		frame.pack();
		frame.setVisible(true);
	}
}
