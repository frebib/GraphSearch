package search.graph;

import java.util.Comparator;

public class NodeComparator<A> implements Comparator<Node<A>> {

	@Override
	public int compare(Node<A> o1, Node<A> o2) {
		return (int)(o1.getF() - o2.getF());
	}

}
