
public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts {

	@Override
	public double fOfXY(int x, int y) {
		return (Complex.multiply(new Complex(x, y), new Complex(x, y))).norm(); //multiplies two Complexes and computes their norm
	}

	@Override
	public String getName() {
		return "Squared Norm"; //returns what this class does
	}

}
