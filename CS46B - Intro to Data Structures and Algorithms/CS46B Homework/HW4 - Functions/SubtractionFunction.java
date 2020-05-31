
public class SubtractionFunction implements DoubleFunctionOfTwoInts {
	@Override
	public double fOfXY(int x, int y)
	{
		return x - y; //subtracts the y value from the x value and returns the value
	}

	@Override
	public String getName() {
		return "Subtraction"; //returns what this class does
	}

}
