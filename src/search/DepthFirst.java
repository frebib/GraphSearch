package search;

import ilist.IList;
import maybe.Maybe;
import maybe.Predicate;
import search.datastructures.SearchStack;
import search.graph.Node;

/**
 * Searches a Node collection using Depth-First search
 * 
 * @author Joe Groocock
 */

public class DepthFirst {

	/**
	 * Finds a Node in a {@link search.graph.Graph} using Depth First Search
	 * 
	 * @param start The {@link search.graph.Node} to start searching from
	 * @param p A {@link Predicate} to check each node against determining the target {@link search.graph.Node}
	 * @return Maybe a path from {@code start} to a {@link search.graph.Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p) {
		return Search.findNodeFrom(start, p, new SearchStack<Node<A>>());
	}

	/**
	 * Finds a path between connected nodes using Depth First Search
	 * 
	 * @param start The {@link search.graph.Node} to start path-finding from
	 * @param p A {@link Predicate} to check each node against determining the destination {@link search.graph.Node}
	 * @return Maybe a path from {@code start} to a {@link search.graph.Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Predicate<A> p) {
		return Search.findPathFrom(start, p, new SearchStack<Node<A>>());
	}
}