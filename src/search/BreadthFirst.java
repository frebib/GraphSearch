package search;

import search.graph.Node;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreadthFirst {
	public static <A> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p) {
		// Uses a double ended queue to act as a queue that stores all of the nodes that need to be expanded
		Queue<Node<A>> frontier = new ArrayDeque<Node<A>>();
		// Create a set to store visited nodes
		Set<Node<A>> vstd = new HashSet<Node<A>>();
		// Create a node to represent the node currently being expanded
		Node<A> node;
		// Add the starting node to the frontier
		frontier.add(start);
		// While there are still nodes that need to be expanded
		while (!frontier.isEmpty()) {
			// Retrieve and remove the head of the queue for expansion
			node = frontier.poll();
			if (!vstd.contains(node))
				// If the node satisfies the predicate
				if (p.holds(node.getContents()))
					// Return "just" the node
					return new Just<Node<A>>(node);
				else {
					vstd.add(node);
					// If the node isn't the one being searched for add all of its connected nodes to the frontier queue and visited set if they have not already been visited
					for (Node<A> suc : node.getSuccessors())
						frontier.add(suc);
				}
		}
		// If no node could be found that satisfies the predicate return "nothing"
		return new Nothing<Node<A>>();
	}
}