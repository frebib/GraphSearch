package search;

import ilist.IList;
import maybe.Maybe;
import search.datastructures.SearchQueue;
import search.graph.Node;

/**
 * Searches a Node collection using Breadth-First search
 * 
 * @author Joe Groocock
 */

public class BreadthFirst {

	/**
	 * Finds a Node in a {@link search.graph.Graph} using Breadth First Search
	 * 
	 * @param start The {@link Node} to start searching from
	 * @param p A {@link Predicate} to check each node against determining the target {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A extends Heuristic<A>> Maybe<Node<A>> findNodeFrom(Node<A> start, Node<A> goal) {
		SearchFunction<A> nothing = (a, b) -> 0f;
		return Search.findNodeFrom(start, goal, new SearchQueue<Node<A>>(), nothing, nothing);
	}

	/**
	 * Finds a path between connected nodes using Breadth First Search
	 * 
	 * @param start The {@link Node} to start path-finding from
	 * @param p A {@link Predicate} to check each node against determining the destination {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A extends Heuristic<A>> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Node<A> goal) {
		SearchFunction<A> nothing = (a, b) -> 0f;
		return Search.findPathFrom(start, goal, new SearchQueue<Node<A>>(), nothing, nothing);
	}
}