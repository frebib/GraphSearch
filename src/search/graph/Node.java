package search.graph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A> {
	private A contents;
	private double f;
	private final Collection<Node<A>> successors;

	public Node(A contents) {
		this.contents = contents;
		this.successors = new LinkedHashSet<Node<A>>();
		this.f = 0.0;
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

	public double getF(){
		return f;
	}
	
	public void setF(double f){
		this.f = f;
	}

	@Override
	public String toString() {
		return "Node" + contents.toString();
	}
}
