package search.graph;

import search.Heuristic;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A> implements Heuristic<A> {
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

	public boolean contentsEquals(A c) {
		return contents.equals(c);
	}
	@Override
	public String toString() {
		return "Node" + contents.toString();
	}
}
