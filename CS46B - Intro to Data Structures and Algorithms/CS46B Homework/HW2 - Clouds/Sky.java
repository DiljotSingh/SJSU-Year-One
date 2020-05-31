
import java.util.ArrayList;

//Constructs a Sky that contains an ArrayList which can store and manipulate Clouds
public class Sky {
	private ArrayList<Cloud> clouds;

	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}
	
	/**
	 * Adds this Cloud to the ArrayList clouds
	 * @param c the Cloud to add
	 * @return true
	 */
	public boolean add(Cloud c) {
		clouds.add(c);
		return true;
	}
	/**
	 * Gets the mean height of all the clouds in the ArrayList using an enhanced for loop
	 * @return sum/clouds.size(), the total height divided by how many Clouds there are
	 */
	public float getMeanHeight() {
		float sum = 0;
		for (Cloud c : clouds) {
			sum = sum + c.getHeight();
		}
		return sum / clouds.size();
	}

	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining")) {
			System.out.println("Bad StratusCloud::rain");
		}
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining")) {
			System.out.println("Bad CumulusCloud::rain");
		}
		CirrusCloud cirr = new CirrusCloud(300, 3000);
		if (!cirr.rain().startsWith("I cannot make")) {
			System.out.println("Bad CirrusCloud::rain");
		}
		Sky sky = new Sky();
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		float mean = sky.getMeanHeight();
		if (mean < 1799 || mean > 1801) {
			System.out.println("Bad mean height: expected 1800, saw " + mean);
		}
		System.out.println("Everything (else) is ok");

	}
}
