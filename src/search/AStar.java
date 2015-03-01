package search;

import ilist.IList;
import maybe.Maybe;
import maybe.Predicate;
import search.datastructures.SearchPriorityQueue;
import search.graph.Node;

public class AStar {
	public static <A extends Comparable<A>> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p) {
		return Search.findNodeFrom(start, p, new SearchPriorityQueue<Node<A>>());
	}
	public static <A> Maybe<IList<Node<A>>> findPathFrom(Node<A> start, Predicate<A> p) {
		return Search.findPathFrom(start, p, new SearchPriorityQueue<Node<A>>());
	}
}