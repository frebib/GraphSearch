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
	 * Finds a Node in a Graph using A* Search
	 *
	 * @param start The {@link search.Node} to start searching from
	 * @param goal The {@link search.Node} to searching for
	 * @param heuristic A Heuristic to estimate the distance to the goal {@link search.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.Node}
	 * @return A {@link search.Node} from {@link search.Node} {@code start} to {@link search.Node} {@code goal}
	 */
	public static <A> Node<A> findNodeFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findNodeFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}
	/**
	 * Finds a path between connected {@link search.Node}{@code s} using A* Search
	 *
	 * @param start The {@link search.Node} to start path-finding from
	 * @param goal The {@link search.Node} to searching for
	 * @param heuristic A Heuristic to estimate the distance to the goal {@link search.Node}
	 * @param cost A Cost function to calculate the precise distance from the previous {@link search.Node}
	 * @return A Path from {@link search.Node} {@code start} to {@link search.Node} {@code goal}
	 */
	public static <A> List<Node<A>> findPathFrom(Node<A> start, Node<A> goal, SearchFunction<A> heuristic, SearchFunction<A> cost) {
		return Search.findPathFrom(start, goal, new SearchPriorityQueue<Node<A>>(new NodeComparer<A>()), heuristic, cost);
	}
}