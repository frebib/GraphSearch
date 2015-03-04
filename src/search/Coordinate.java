package search;

/**
 * Represents a 2D integer Co-ordinate
 * 
 * @author Martin Escardo
 */

public class Coordinate {
	/**
	 * Represents the X value of the Coordinate
	 */
	public int x;
	/**
	 * Represents the Y value of the Coordinate
	 */
	public int y;

	/**
	 * Creates a Coordinate from {@code x} and {@code y} values
	 * 
	 * @param x The X value
	 * @param y The Y value
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		return x + y << 16;
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
