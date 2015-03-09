package search;

import search.datastructures.SearchPriorityQueue;

import java.util.List;

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
	 * @param goal The {@link search.graph.Node} to searching for
	 * @param heuristic A Heuristic {@link maybe.Function2} to estimate the distance to the goal {@link search.graph.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.graph.Node}
	 * @return {@link maybe.Maybe} a {@link search.graph.Node} from {@link search.graph.Node} {@code start} to {@link search.graph.Node} {@code goal}
	 */
	public static <A> Node<A> findNodeFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findNodeFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}
	/**
	 * Finds a path between connected {@link search.graph.Node}{@code s} using A* Search
	 *
	 * @param start The {@link search.graph.Node} to start path-finding from
	 * @param goal The {@link search.graph.Node} to searching for
	 * @param heuristic A Heuristic {@link maybe.Function2} to estimate the distance to the goal {@link search.graph.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.graph.Node}
	 * @return {@link maybe.Maybe} a Path from {@link search.graph.Node} {@code start} to {@link search.graph.Node} {@code goal}
	 */
	public static <A> List<Node<A>> findPathFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findPathFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}
}