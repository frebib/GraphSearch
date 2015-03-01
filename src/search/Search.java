package search;

import ilist.Cons;
import ilist.IList;
import ilist.Nil;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;
import search.datastructures.DataStructure;
import search.graph.Node;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Search {
	public static <A, B extends DataStructure<Node<A>>> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Predicate<A> p, B frontier) {
		Map<Node<A>, Node<A>> visited = new LinkedHashMap<Node<A>, Node<A>>();
		Node<A> node = null;

		frontier.add(start);						// Adds the node to the frontier in the manner specified by the data structure
		while (!frontier.isEmpty()) {
			node = frontier.getHead();				// Get and remove the first element in the manner specified by the data structure
			if (p.holds(node.getContents())) {
				visited.put(start, null);			// Add start Node as it will be first element in list (last one to be added)

				IList<Node<A>> list = new Nil<>();
				while (node != null) {
					list = new Cons<>(node, list);
					node = visited.get(node);
				}

				return new Just<>(list);
			}
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.containsKey(suc)) {
						frontier.add(suc);
						visited.put(suc, node);
					}
		}
		return new Nothing<>();
	}

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
		return new Nothing<>();
	}
}
