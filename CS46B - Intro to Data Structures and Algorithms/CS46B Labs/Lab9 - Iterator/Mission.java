package space;

import java.util.ArrayList;

public class Mission implements Comparable<Mission> {
	private String destination;
	private float cost;

	public Mission(String destination, Float cost) {
		this.destination = destination;
		this.cost = cost;
	}

	public String getDestination() {
		return destination;
	}

	public float getCost() {
		return cost;
	}

	// Compare by cost, then by destination.
	public int compareTo(Mission that) {
		int value = Float.compare(this.cost, that.cost);
		if (value == 0) {
			value = this.destination.compareTo(that.destination);
		}
		return value;

	}

	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x) {
		Mission that = (Mission) x;
		return this.compareTo(that) == 0;

	}

	// As you saw in lecture, create an ArrayList<Object>. Add destination and
	// cost to the list. Return the list's hash code.
	public int hashCode() {
		ArrayList<Object> var = new ArrayList<>();
		var.add(this.destination);
		var.add(this.cost);
		return var.hashCode();

	}

	public static void main(String[] args) {
		Mission test = new Mission("Mars", 100f);
		Mission test2 = new Mission("Jupiter", 300f);
		Mission test3 = new Mission("Mars", 100f);

		System.out.println(test.getCost()); // 100f
		System.out.println(test.getDestination()); // Mars
		System.out.println(test.compareTo(test2)); // Should be -1
		System.out.println(test.equals(test2)); // false
		System.out.println(test.equals(test3)); // true

		;
	}

	public String toString() {
		return "Mission to " + destination + " will cost " + cost;
	}
}
