package func;

public class HypotFunction implements DoubleFunctionOfTwoInts {
	@Override
	public double fOfXY(int x, int y)
	{
		return Math.hypot(x, y); //treats x and y as two legs of a triangle and calculates the hypotenuse (square root of (x^2+y^2))
	}
	@Override
	public String getName()
	{
		return "Hypotenuse"; //returns what this class does
	}

}
