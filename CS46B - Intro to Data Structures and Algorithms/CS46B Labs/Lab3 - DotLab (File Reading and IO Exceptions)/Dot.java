package dotlab;

public class Dot {
	private static String[] LEGAL_COLOR_NAMES = { "RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE",
			"BLACK" };
	String color;
	int x;
	int y;
	int radius;

	public String getColorName() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public Dot(String colorName, int x, int y, int radius) {
		String legalColors = "";
		for (String c : LEGAL_COLOR_NAMES) {
			legalColors = legalColors + c;
		}
		if (legalColors.contains(colorName.toUpperCase())) {
			this.color = colorName;

		} else {
			throw new IllegalArgumentException(colorName + " is not a legal color name.");

		}

		this.x = x;
		this.y = y;
		this.radius = radius;

	}

	public static void main(String[] args) {
		Dot legalDot = new Dot("yellow", 2, 2, 2);
		System.out.println(legalDot.toString());

	}

	public String toString() {
		String description = "Color:" + color + " X:" + x + " Y:" + y + " Radius:" + radius;
		return description;
	}

}
