package search.graph;

import java.util.Comparator;

public class NodeComparator<A> implements Comparator<Node<A>> {

	@Override
	public int compare(Node<A> n1, Node<A> n2) {
		return (int)(n1.getF() - n2.getF());
	}

}
