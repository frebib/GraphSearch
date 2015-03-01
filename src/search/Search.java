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

		if (p.holds(start.getContents()))
			return new Nothing<>();

		frontier.add(start);
		while (!frontier.isEmpty()) {
			node = frontier.getHead();
			if (p.holds(node.getContents())) {		// At this point we reconstruct the path followed from the visited Map

				visited.put(start, null);			// Add start Node as it will be first element in list (last one to be added)

				IList<Node<A>> list = new Nil<>();
				while (node != null) {				// Iterate through the nodes in the visited map
					list = new Cons<>(node, list);	// Add the current node to the resulting path
					node = visited.get(node);		// Get the parent of the node from the Key-Value
				}									// pair in the Map using the node as the key

				assert (list.size() > 1);			// It should never be that the only node in the list
				return new Just<>(list);			// is the start node; that should catch at the start.
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
						frontier.add(suc);			// Add all successors to the frontier set so they can be searched
						visited.add(suc);			// on a later iteration of this while loop
					}
		}
		return new Nothing<>();
	}
}
