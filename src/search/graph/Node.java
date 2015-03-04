package search.graph;

import search.Heuristic;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A extends Heuristic<A>> {
	private final Collection<Node<A>> successors;
	public A contents;

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
	public float getF() {
		return contents.getF();
	}

	public boolean contentsEquals(A c) {
		return contents.equals(c);
	}
	@Override
	public String toString() {
		return "Node" + contents.toString();
	}
}
