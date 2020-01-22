package func;

public class ModFunction implements DoubleFunctionOfTwoInts {
	@Override
	public double fOfXY(int x, int y) {
		if (y == 0) { //if y is zero then changes y to 1 since you cannot compute x % 0;
			y = 1;
		}

		
		return x % y; //returns the remainder from the first input divided by the second
	}
	@Override
	public String getName()
	{
		return "Modulo"; //returns what this class does
	}

}
