
public class AdditionFunction implements DoubleFunctionOfTwoInts
{
	@Override
	public double fOfXY(int x, int y)
	{
		return x + y; // adds the two parameters (x, y) together and returns them
	}
	
	
	@Override
	public String getName()
	{
		return "Addition"; // states what this class does
	}
}
