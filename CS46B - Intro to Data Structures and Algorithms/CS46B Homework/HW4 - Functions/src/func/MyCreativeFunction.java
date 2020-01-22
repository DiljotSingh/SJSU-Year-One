package func;

public class MyCreativeFunction implements DoubleFunctionOfTwoInts {

	@Override
	public double fOfXY(int x, int y) {
		
		if (x < 0) { //all negative x-values (left side quadrants) become positive
			x = -1 * x;
		} else {
			x = (int) Math.pow(x, 3); // all positive x-values (right side quadrants) get cubed
		}
		if (y < 0) { // all negative y-values (quadrants below x-axis) become inverted
			y = 1 / y;
		} else {
			y = (int) Math.pow(y, 3); //all positive y-values (above x-axis) get cubed
		}

		Complex base = new Complex(x, y); //Constructs a Complex with the x and y values manipulated through the if/else statements above
		return base.norm(); //returns the norm of this specific x and y value Complex
	}

	@Override
	public String getName() {
		return "MyCreativeFunction"; //returns what this class does
	}

}
