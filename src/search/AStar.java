package search;

import ilist.IList;
import maybe.Maybe;
import search.datastructures.SearchPriorityQueue;
import search.graph.Node;
import search.graph.NodeComparer;

/**
 * Searches a Node collection using A* search
 * 
 * @author Joe Groocock
 */

public class AStar {

	/**
	 * Finds a Node in a {@link search.graph.Graph} using A* Search
	 * 
	 * @param start The {@link search.graph.Node} to start searching from
	 * @param p A {@link Predicate} to check each node against determining the target {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<Node<A>> findNodeFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findNodeFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}

	/**
	 * Finds a path between connected nodes using A* Search
	 * 
	 * @param start The {@link Node} to start path-finding from
	 * @param p A {@link Predicate} to check each node against determining the destination {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findPathFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}
}