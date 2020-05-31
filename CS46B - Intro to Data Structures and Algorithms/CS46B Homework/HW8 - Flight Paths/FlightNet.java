

import java.util.HashSet;

/**
 * Models an airline company's air routes
 * 
 * @author Diljot Singh
 *
 */
public class FlightNet extends HashSet<Airport> {
	
	/**
	 * Checks to see if the parameter name is available in this FlightNet
	 * @param name the name to check for availability
	 * @return true if the name does not already exist in the FlightNet
	 */
	public boolean nameIsAvailable(String name) {
		for (Airport port : this) {
			if (port.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Connects two Airports to each other
	 * @param a1 the first Airport to connect
	 * @param a2 the second Airport to connect
	 */
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	/**
	 * Disconnects two Airports from each other
	 * @param a1 the first Airport to disconnect
	 * @param a2 the second Airport to disconnect
	 */
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	/**
	 * Removes the parameter Airport and disconnects it from all other Airports
	 * @param removeMe the Airport to remove
	 */
	public void removeAndDisconnect(Airport removeMe) {
		this.remove(removeMe);
		for (Airport port : this) {
			port.disconnectFrom(removeMe);
		}
	}
	
	/**
	 * Finds the Airport closest to the given (x,y) coordinates, within a maximum distance
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param maximumDistance the maximum distance the Airport can be from the coordinates
 	 * @return the Airport that was closest within the maximum distance, if found. Return null if not.
	 */
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for (Airport port : this) {
			if (Math.abs((Math.hypot(x, y)) - Math.hypot(port.getX(), port.getY())) <= maximumDistance) {
				return port;
			}

		}
		return null;

	}

}
