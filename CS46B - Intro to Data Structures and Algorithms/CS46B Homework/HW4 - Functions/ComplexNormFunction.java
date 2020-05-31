
public class ComplexNormFunction implements DoubleFunctionOfTwoInts {

	@Override
	public double fOfXY(int x, int y) {
		return new Complex(x,y).norm(); //returns the norm of the two inputs from the Complex
	}

	@Override
	public String getName() {
		return "Norm"; //returns what this class does
	}

}
