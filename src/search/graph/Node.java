package search.graph;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A> {
	private final Collection<Node<A>> successors;
	public final A contents;

	private float heuristic, cost;

	public Node(A contents) {
		this.contents = contents;
		this.successors = new LinkedHashSet<Node<A>>();
	}

	public void addSuccessor(Node<A> s) {
		successors.add(s);
	}
	public Collection<Node<A>> getSuccessors() {
		return successors;
	}

	public float getCost() {
		return cost;
	}
	public float getHeuristic() {
		return heuristic;
	}
	public float getF() {
		return cost + heuristic;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setHeuristic(float heuristic) {
		this.heuristic = heuristic;
	}

	public boolean contentsEquals(A c) {
		return contents.equals(c);
	}
	@Override
	public String toString() {
		return "Node" + contents.toString();
	}
}
