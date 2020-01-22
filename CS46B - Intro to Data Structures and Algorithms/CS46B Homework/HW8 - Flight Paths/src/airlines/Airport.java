package airlines;

import java.util.*;

public class Airport implements Comparable<Airport> {
	private String name;
	private int x;
	private int y;
	private Set<Airport> connections; // all airports with a direct route to/from this airport

	/**
	 * Constructs an Airport with a name and x and y coordinates
	 * 
	 * @param name the name of this Airport
	 * @param x    the x coordinate of this Airport
	 * @param y    the y coordinate of this Airport
	 */
	public Airport(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}

	/**
	 * Gets the name of this Airport
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the x coordinate of this Airport
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y coordinate of this Airport
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets all the connections of this Airport
	 * 
	 * @return an ArrayList of the connections
	 */
	public List<Airport> getConnections() {
		return new ArrayList<>(connections);
	}

	// Adds "that" airport to the list of connections. This is a one-way route, so
	// don't add this airport to that's list of connections.

	/**
	 * Adds another Airport to this Airport's list of connections, but does not add
	 * this Airport to the other Airport's list of connections
	 * 
	 * @param that the other Airport to connect to this Airport
	 */
	public void connectTo(Airport that) {
		this.connections.add(that);

	}

	//
	// Does nothing if this airport is not connected to that.
	//

	/**
	 * Removes an Airport from this Airport's list of connections, if they are
	 * connected
	 * 
	 * @param that the Airport to remove from the list of connections
	 */
	public void disconnectFrom(Airport that) {
		if (this.isConnectedTo(that)) {
			this.connections.remove(that);
		}

	}

	// Use best practice.

	/**
	 * Returns true if these two Airports have the same name
	 */
	public boolean equals(Object x) {
		Airport that = (Airport) x;
		return ((this.compareTo(that)) == 0);
	}

	// Just compare by airport name.

	/**
	 * Compares this Airport's name to another Airport's name to determine whether
	 * this Airport should be sorted in front or behind the other Airport
	 * 
	 * @return -1 if this Airport should come before the other Airport, 1 if after,
	 *         and 0 if they have the same name
	 */
	public int compareTo(Airport that) {
		return this.name.compareTo(that.name);

	}

	/**
	 * Checks if this Airport is connected to another Airport
	 * 
	 * @param that the other Airport to check for connection
	 * @return true if these two Airports are connected
	 */
	public boolean isConnectedTo(Airport that) {
		return this.connections.contains(that);

	}

	public String toString() {
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
