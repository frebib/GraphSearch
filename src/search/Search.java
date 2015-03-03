package search;

import ilist.Cons;
import ilist.IList;
import ilist.Nil;
import maybe.Function2;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;
import search.datastructures.DataStructure;
import search.graph.Node;
import search.graph.NodeComparator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * A class to conduct different types of search on a given data structure
 * 
 * @author Jack Hair
 * @author Joe Groocock
 * @author Hannah Evans
 */

public class Search {

	/**
	 * Finds a Node in a {@link search.graph.Graph}
	 * 
	 * @param start The {@link search.graph.Node} to start searching from
	 * @param p A {@link Predicate} to check each node against determining the target {@link search.graph.Node}
	 * @param frontier A {@link Collection} to store the frontier set in
	 * @return Maybe a path from {@code start} to a {@link search.graph.Node} which satisfies the {@link Predicate} {@code p}
	 */
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

	/**
	 * Finds a path between connected nodes
	 * 
	 * @param start The {@link search.graph.Node} to start path-finding from
	 * @param p A {@link Predicate} to check each node against determining the destination {@link search.graph.Node}
	 * @param frontier A {@link Collection} to store the frontier set in
	 * @return Maybe a path from {@code start} to a {@link search.graph.Node} which satisfies the {@link Predicate} {@code p}
	 */
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

	public static <A> Maybe<IList<Node<A>>> findPathFromAStar(Node<A> origin, Node<A> destination, Function2<Node<A>, Node<A>, Double> h, Function2<Node<A>, Node<A>, Double> d) {
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Queue<Node<A>> pending = new PriorityQueue<Node<A>>(new NodeComparator<A>());
		Map<Node<A>, Node<A>> pred = new LinkedHashMap<Node<A>, Node<A>>();
		Map<Node<A>, Double> D = new HashMap<Node<A>, Double>();
		D.put(origin, 0.0);
		Map<Node<A>, Double> f = new HashMap<Node<A>, Double>();
		f.put(origin, h.apply(origin, destination));
		origin.setF(h.apply(origin, destination));
		D.put(origin, h.apply(origin, destination));
		Node<A> node = null;

		pending.add(origin);
		while (!pending.isEmpty()) {
			node = pending.poll();

			double cost;
			if (node.equals(destination)) {		// At this point we reconstruct the path followed from the visited Map

				pred.put(node, null);			// Add start Node as it will be first element in list (last one to be added)

				IList<Node<A>> list = new Nil<>();
				while (node != null) {				// Iterate through the nodes in the visited map
					list = new Cons<>(node, list);	// Add the current node to the resulting path
					node = pred.get(node);		// Get the parent of the node from the Key-Value
				}									// pair in the Map using the node as the key

				assert (list.size() > 1);			// It should never be that the only node in the list
				return new Just<>(list);			// is the start node; that should catch at the start.
			}
			else
				visited.add(node);
			for (Node<A> suc : node.getSuccessors())
				if (!visited.contains(suc)) {
					cost = D.get(node) + d.apply(node, suc);
					if (!pending.contains(suc) || cost < D.get(suc)) {
						pred.put(suc, node);
						D.put(suc, cost);
						f.put(suc, D.get(suc) + h.apply(suc, destination));
						suc.setF(D.get(suc) + h.apply(suc, destination));
						if (!pending.contains(suc))
							pending.add(suc);
					}
				}
		}
		return new Nothing<>();
	}
}
