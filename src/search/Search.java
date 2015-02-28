package search;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;
import search.datastructures.DataStructure;

import java.util.HashSet;
import java.util.Set;

public class Search {

	public static <A, B extends DataStructure<Node<A>>> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p, B frontier) {
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Node<A> node;

		frontier.add(start);						// Adds the node to the frontier in the manner specified by the data structure
		while (!frontier.isEmpty()) {
			node = frontier.getHead();				// Get and remove the first element in the manner specified by the data structure
			if (p.holds(node.getContents()))
				return new Just<Node<A>>(node);		// Return found goal Node
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.contains(suc)) {
						frontier.add(suc);
						visited.add(suc);
					}
		}
		return new Nothing<Node<A>>();
	}
}
