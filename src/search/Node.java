package search;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A> {
	private A contents;
	private final Collection<Node<A>> successors;

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

	public A getContents() {
		return contents;
	}

	public boolean contentsEquals(A c) {
		return contents.equals(c);
	}

	public float getHeuristic(Node<A> goal) {
		throw new NotImplementedException();
		// TODO: Add Heuristic function between co-ordinates using Point.distance()
	}

	@Override
	public String toString() {
		return "Node" + contents.toString();
	}
}
