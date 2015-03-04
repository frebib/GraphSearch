package search.graph;

import search.Heuristic;

/**
 * Represents a 2D integer Co-ordinate
 * 
 * @author Martin Escardo
 */

public class Coordinate implements Heuristic<Coordinate> {
	/**
	 * Represents the X value of the Coordinate
	 */
	public int x;
	/**
	 * Represents the Y value of the Coordinate
	 */
	public int y;

	private float heuristic, cost;

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
	public float getCost() {
		return cost;
	}
	@Override
	public float getHeuristic() {
		return heuristic;
	}
	@Override
	public float getF() {
		return cost + heuristic;
	}

	@Override
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public void setHeuristic(float heuristic) {
		this.heuristic = heuristic;
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
