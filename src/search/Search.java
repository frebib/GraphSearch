package search;

import ilist.Cons;
import ilist.IList;
import ilist.Nil;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import search.datastructures.DataStructure;
import search.graph.Node;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
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
	public static <A extends Heuristic<A>, B extends DataStructure<Node<A>>> Maybe<Node<A>> findNodeFrom(Node<A> start, Node<A> goal, B frontier, SearchFunction<A> heuristic, SearchFunction<A> costFunc) {
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Node<A> node = null;

		if (start.contentsEquals(goal.contents))
			return new Nothing<>();

		start.contents.setHeuristic(heuristic.apply(start, goal));
		start.contents.setCost(0);
		frontier.add(start);						// Adds the node to the frontier in the manner specified by the data structure

		while (!frontier.isEmpty()) {
			node = frontier.getHead();				// Get and remove the first element in the manner specified by the data structure
			if (node.contentsEquals(goal.contents))
				return new Just<Node<A>>(node);		// Return found goal Node
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.contains(suc)) {
						float cost = node.contents.getCost() + costFunc.apply(node, suc);
						suc.contents.setHeuristic(heuristic.apply(suc, goal));
						suc.contents.setCost(cost);

						frontier.add(suc);				// Add all successors to the frontier set so they can
						visited.add(suc);				// be searched on a later iteration of this while loop
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
	public static <A extends Heuristic<A>, B extends DataStructure<Node<A>>> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Node<A> goal, B frontier, SearchFunction<A> heuristic, SearchFunction<A> costFunc) {
		Map<Node<A>, Node<A>> visited = new LinkedHashMap<Node<A>, Node<A>>();
		Node<A> node = null;

		if (start.contentsEquals(goal.contents))
			return new Nothing<>();

		start.contents.setHeuristic(heuristic.apply(start, goal));
		start.contents.setCost(0);
		frontier.add(start);

		while (!frontier.isEmpty()) {
			node = frontier.getHead();
			if (node.contentsEquals(goal.contents)) {	// At this point we reconstruct the path followed from the visited Map

				visited.put(start, null);				// Add start Node as it will be first element in list (last one to be added)

				IList<Node<A>> list = new Nil<>();
				while (node != null) {					// Iterate through the nodes in the visited map
					list = new Cons<>(node, list);		// Add the current node to the resulting path
					node = visited.get(node);			// Get the parent of the node from the Key-Value
				}										// pair in the Map using the node as the key

				assert (list.size() > 1);				// It should never be that the only node in the list
				return new Just<>(list);				// is the start node; that should catch at the start.
			}
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.containsKey(suc)) {
						float cost = node.contents.getCost() + costFunc.apply(node, suc);
						suc.contents.setHeuristic(heuristic.apply(suc, goal));
						suc.contents.setCost(cost);

						frontier.add(suc);					// Add successor to frontier to allow it to be searched from
						visited.put(suc, node);				// Set the node as visited
					}
		}
		return new Nothing<>();
	}
	/*
	public static <A> Maybe<IList<Node<A>>> findPathFromAStar(Node<A> origin, Node<A> goal, Function2<Node<A>, Node<A>, Double> heuristicFunc, Function2<Node<A>, Node<A>, Double> costFunc) {
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Queue<Node<A>> pending = new PriorityQueue<Node<A>>(new NodeComparator<A>());
		Map<Node<A>, Node<A>> predecessors = new LinkedHashMap<Node<A>, Node<A>>();
		Map<Node<A>, Double> D = new HashMap<Node<A>, Double>();
		Map<Node<A>, Double> f = new HashMap<Node<A>, Double>();
		D.put(origin, 0.0);
		f.put(origin, heuristicFunc.apply(origin, goal));
		origin.setF(heuristicFunc.apply(origin, goal));
		D.put(origin, heuristicFunc.apply(origin, goal));
		Node<A> node = null;

		pending.add(origin);
		while (!pending.isEmpty()) {
			node = pending.poll();

			double cost;
			if (node.equals(goal)) {		// At this point we reconstruct the path followed from the visited Map
				//for (Map.Entry<Node<A>, Node<A>> e : pred.entrySet())
				//	System.out.println(e.getKey() + ": " + e.getValue());

				predecessors.put(origin, null);			// Add start Node as it will be first element in list (last one to be added)

				IList<Node<A>> list = new Nil<>();
				while (node != null) {				// Iterate through the nodes in the visited map
					list = new Cons<>(node, list);	// Add the current node to the resulting path
					node = predecessors.get(node);		// Get the parent of the node from the Key-Value
				}									// pair in the Map using the node as the key

				assert (list.size() > 1);			// It should never be that the only node in the list
				return new Just<>(list);			// is the start node; that should catch at the start.
			}
			else
				visited.add(node);
			for (Node<A> suc : node.getSuccessors())
				if (!visited.contains(suc)) {
					cost = D.get(node) + costFunc.apply(node, suc);
					if (!pending.contains(suc) || cost < D.get(suc)) {
						predecessors.put(suc, node);
						D.put(suc, cost);
						f.put(suc, D.get(suc) + heuristicFunc.apply(suc, goal));
						suc.setF(D.get(suc) + heuristicFunc.apply(suc, goal));
						if (!pending.contains(suc)) {
							pending.add(suc);

							Object[] arr = pending.toArray();
							for (int i = 0; i < arr.length - 1; i++) {
								System.out.println(arr[i] + ": " + f.get(arr[i]));
								assert (f.get(arr[i]) > f.get(arr[i + 1]));
								System.out.println(f.get(arr[i]) > f.get(arr[i + 1]));
							}
							System.out.println("----------------");
						}
					}
				}
		}
		return new Nothing<>();
	}
	*/
}
