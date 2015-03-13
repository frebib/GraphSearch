package search;

import search.datastructures.SearchStack;

import java.util.List;

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
	 * @param goal The {@link search.graph.Node} to searching for
	 * @return {@link maybe.Maybe} a {@link search.graph.Node} from {@link search.graph.Node} {@code start} to {@link search.graph.Node} {@code goal}
	 */
	public static <A> Node<A> findNodeFrom(Node<A> start, Node<A> goal) {
		SearchFunction<A> nothing = new SearchFunction<A>() {
			@Override
			public float apply(Node<A> a, Node<A> b) {
				return 0f;
			}
		};
		return Search.findNodeFrom(start, goal, new SearchStack<Node<A>>(), nothing, nothing);
	}
	/**
	 * Finds a path between connected {@link search.graph.Node}{@code s} using Depth First Search
	 *
	 * @param start The {@link search.graph.Node} to start path-finding from
	 * @param goal The {@link search.graph.Node} to searching for
	 * @return {@link maybe.Maybe} a Path from {@link search.graph.Node} {@code start} to {@link search.graph.Node} {@code goal}
	 */
	public static <A> List<Node<A>> findPathFrom(Node<A> start, Node<A> goal, SearchProgress prog) {
		SearchFunction<A> nothing = new SearchFunction<A>() {
			@Override
			public float apply(Node<A> a, Node<A> b) {
				return 0f;
			}
		};
		return Search.findPathFrom(start, goal, new SearchStack<Node<A>>(), nothing, nothing, prog);
	}
}