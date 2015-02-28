package search;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node<A>{
	private  A contents;
	private final Collection<Node<A>> successors;
	
	public Node(A contents){
		this.contents = contents;
		this.successors = new LinkedHashSet<Node<A>>();
	}
	
	public Collection<Node<A>> successors(){
		return successors;
	}
	public void addSuccessor(Node<A> s){
		successors.add(s);
	}
	
	public boolean contentsEquals (A c) {
		return contents.equals(c);
	}
	
	public A contents(){
		return contents;
	}
	
	public String toString(){
		return contents().toString();
	}
}
