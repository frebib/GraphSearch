package search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a Node that carries a contents and it's successors
 *
 * @param <A> Payload of the {@link Node}
 * @author Martin Escardo
 */
public class Node<A> {
	private final Collection<Node<A>> successors;
	/**
	 * The Object that the {@link Node} represents
	 */
	private final A payload;
	private float heuristic, cost;

	/**
	 * Creates a new Node with a contents
	 *
	 * @param contents Object for the Node to represent
	 */
	public Node(A contents) {
		this.payload = contents;
		this.successors = new ArrayList<Node<A>>();

		this.cost = Float.POSITIVE_INFINITY;
	}

	/**
	 * Returns the payload of the {@link Node}
	 *
	 * @return The payload of the {@link Node}
	 */
	public A getPayload() {
		return payload;
	}

	/**
	 * Adds a successor
	 *
	 * @param s Successor to the {@link Node}
	 */
	public void addSuccessor(Node<A> s) {
		if (s != null)
			successors.add(s);
	}

	/**
	 * Removes a successor
	 *
	 * @param s Successor to be removed
	 */
	public void removeSuccessor(Node<A> s) {
		if (s != null)
			successors.remove(s);
	}

	/**
	 * Gets a {@link Collection} of all successors
	 *
	 * @return The successors to the {@link Node}
	 */
	public Collection<Node<A>> getSuccessors() {
		return successors;
	}

	/**
	 * Gets the stored {@code Cost} for searching
	 *
	 * @return The {@code Cost} value
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * Sets the {@code cost} value
	 *
	 * @param cost {@code Cost} value
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * Gets the {@code Heuristic} value for searching
	 *
	 * @return The {@code Heuristic} value
	 */
	public float getHeuristic() {
		return heuristic;
	}

	/**
	 * Sets the {@code Heuristic} value
	 *
	 * @param heuristic {@code Heuristic} value
	 */
	public void setHeuristic(float heuristic) {
		this.heuristic = heuristic;
	}

	/**
	 * Gets the combined value of {@code cost} and {@code heuristic} values
	 *
	 * @return {@code cost} + {@code heuristic}
	 */
	public float getF() {
		return cost + heuristic;
	}

	/**
	 * Compares the contents to Element {@code c}
	 *
	 * @param c Element to compare to {@link Node} contents
	 * @return true if the contents are .equal()
	 */
	public boolean contentsEquals(A c) {
		return payload.equals(c);
	}

	@Override
	public String toString() {
		return "Node " + payload.toString();
	}
}
