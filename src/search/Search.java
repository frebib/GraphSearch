package search;

import rp.util.Collections;
import search.datastructures.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class to conduct different types of search on a given data structure
 *
 * @author Jack Hair
 * @author Joe Groocock
 * @author Hannah Evans
 */

@SuppressWarnings("deprecation")
public class Search {
	/**
	 * Finds a Node in a Graph
	 *
	 * @param start The {@link search.Node} to start searching from
	 * @param goal The {@link search.Node} to searching for
	 * @param frontier A {@link search.datastructures.DataStructure} to store the frontier set of the {@link Search}
	 * @param heuristic A Heuristic to estimate the distance to the goal {@link search.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.Node}
	 * @return A {@link search.Node} from {@link search.Node} {@code start} to {@link search.Node} {@code goal}
	 */
	public static <A, B extends DataStructure<Node<A>>> Node<A> findNodeFrom(Node<A> start, Node<A> goal, B frontier, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Node<A> node = null;

		if (start.contentsEquals(goal.getPayload()))
			return null;

		start.setHeuristic(heuristic.apply(start, goal));
		start.setCost(0);
		frontier.add(start);						// Adds the node to the frontier in the manner specified by the data structure

		while (!frontier.isEmpty()) {
			node = frontier.getHead();				// Get and remove the first element in the manner specified by the data structure
			if (node.contentsEquals(goal.getPayload()))
				return node;						// Return found goal Node
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.contains(suc)) {
						float costVal = node.getCost() + cost.apply(node, suc);

						suc.setHeuristic(heuristic.apply(suc, goal));
						suc.setCost(costVal);

						frontier.add(suc);				// Add all successors to the frontier set so they can
						visited.add(suc);				// be searched on a later iteration of this while loop
					}
		}
		return null;
	}
	/**
	 * Finds a path between connected {@link search.Node}{@code s}
	 *
	 * @param start The {@link search.Node} to start path-finding from
	 * @param goal The {@link search.Node} to searching for
	 * @param frontier A {@link search.datastructures.DataStructure} to store the frontier set of the {@link Search}
	 * @param heuristic A Heuristic to estimate the distance to the goal {@link search.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.Node}
	 * @return A Path from {@link search.Node} {@code start} to {@link search.Node} {@code goal}
	 */
	public static <A, B extends DataStructure<Node<A>>> List<Node<A>> findPathFrom(Node<A> start, Node<A> goal, B frontier, SearchFunction<A> heuristic, SearchFunction<A> cost, SearchProgress prog) {
		Map<Node<A>, Node<A>> successors = new HashMap<Node<A>, Node<A>>();
		Set<Node<A>> visited = new HashSet<Node<A>>();
		Node<A> node = null;

		float startHeuristic, lowestHeuristic;
		startHeuristic = lowestHeuristic = heuristic.apply(start, goal);

		if (start.contentsEquals(goal.getPayload()))
			return null;

		start.setHeuristic(heuristic.apply(start, goal));
		start.setCost(0);
		frontier.add(start);

		while (!frontier.isEmpty()) {
			node = frontier.getHead();
			visited.add(node);
			if (node.contentsEquals(goal.getPayload())) {	// At this point we reconstruct the path followed from the visited Map
				successors.put(start, null);				// Add start Node as it will be first element in list (last one to be added)

				ArrayList<Node<A>> list = new ArrayList<Node<A>>();
				while (node != null) {					// Iterate through the nodes in the visited map
					list.add(node);						// Add the current node to the resulting path
					node = successors.get(node);		// Get the parent of the node from the Key-Value
				}										// pair in the Map using the node as the key

				assert (list.size() > 1);				// It should never be that the only node in the list
				Collections.reverse(list);				// is the start node; that should catch at the start.
				return list;
			}
			else
				for (Node<A> suc : node.getSuccessors())
					if (!visited.contains(suc)) {
						float costVal = node.getCost() + cost.apply(node, suc);
						if (!frontier.contains(suc) || costVal < suc.getCost()) {
							float h = heuristic.apply(suc, goal);
							if (h < lowestHeuristic && prog != null) {
								lowestHeuristic = h;
								prog.progressMade((float) ((1 - lowestHeuristic / startHeuristic) * 0.95));
							}
							suc.setHeuristic(h);

							successors.put(suc, node);				// Set the node as visited
							frontier.add(suc);					// Add successor to frontier to allow it to be searched from
						}
					}
		}
		return null;
	}
}