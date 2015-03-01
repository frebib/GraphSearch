package search;

import ilist.IList;
import maybe.Maybe;
import maybe.Predicate;
import search.datastructures.SearchQueue;
import search.graph.Node;

public class BreadthFirst {

	/**
	 * Finds a Node in a {@link Graph} using Breadth First Search
	 * 
	 * @param start The {@link Node} to start searching from
	 * @param p A {@link Predicate} to check each node against determining the target {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p) {
		return Search.findNodeFrom(start, p, new SearchQueue<Node<A>>());
	}

	/**
	 * Finds a path between connected nodes using Breadth First Search
	 * 
	 * @param start The {@link Node} to start path-finding from
	 * @param p A {@link Predicate} to check each node against determining the destination {@link Node}
	 * @return Maybe a path from {@code start} to a {@link Node} which satisfies the {@link Predicate} {@code p}
	 */
	public static <A> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Predicate<A> p) {
		return Search.findPathFrom(start, p, new SearchQueue<Node<A>>());
	}
}